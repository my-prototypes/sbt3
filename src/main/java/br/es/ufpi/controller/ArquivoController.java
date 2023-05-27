package br.es.ufpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.es.ufpi.entity.Arquivo;
import br.es.ufpi.service.ArquivoService;

import java.util.List;

@Controller
public class ArquivoController {
    @Autowired
    private ArquivoService arquivoService;

    @GetMapping("/upload")
    public String exibirFormularioUpload() {
        return "upload";
    }

    @PostMapping("/upload")
    public String realizarUpload(@RequestParam("imagem") MultipartFile arquivo) {
        arquivoService.salvarArquivo(arquivo);
        return "redirect:/listaimagens";
    }

    @GetMapping("/listaimagens")
    public String listarArquivos(Model model) {
        model.addAttribute("arquivos", arquivoService.listarArquivos());
        return "listaimagens";
    }

    @GetMapping("/listarminiaturas")
    public String listarArquivosThumbnail(Model model) {
        List<Arquivo> arquivos = arquivoService.listarArquivosThumbnail();
        model.addAttribute("arquivos", arquivos);
        return "listarminiaturas";
    }
}