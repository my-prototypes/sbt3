package br.es.ufpi.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.es.ufpi.entity.Arquivo;
import br.es.ufpi.repository.ArquivoRepository;

import java.util.ArrayList;

@Service
public class ArquivoService {
    @Autowired
    private ArquivoRepository arquivoRepository;

    @Value("${app.upload-dir}")
    private String uploadDir;

    public void salvarArquivo(MultipartFile arquivo) {
        try {
            Path filePath = Path.of(uploadDir, arquivo.getOriginalFilename());
            Files.copy(arquivo.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            String caminho = filePath.toAbsolutePath().toString();
            String nome = arquivo.getOriginalFilename();
            Arquivo arquivoEntity = new Arquivo();
            arquivoEntity.setNome(nome);
            arquivoEntity.setCaminho(caminho);
            arquivoRepository.save(arquivoEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Arquivo> listarArquivos() {
        return arquivoRepository.findAll();
    }

    public List<Arquivo> listarArquivosThumbnail() {
        List<Arquivo> arquivos = new ArrayList<>();
        try {
            Files.list(Path.of(uploadDir))
                    .filter(Files::isRegularFile)
                    .forEach(file -> {
                        Arquivo arquivo = new Arquivo();
                        arquivo.setNome(file.getFileName().toString());
                        arquivo.setCaminho(file.toString());
                        arquivos.add(arquivo);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arquivos;
    }
    
}