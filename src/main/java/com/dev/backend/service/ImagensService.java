package com.dev.backend.service;

import com.dev.backend.entity.Imagens;
import com.dev.backend.entity.Produto;
import com.dev.backend.repository.ImagensRepository;
import com.dev.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class ImagensService {

    @Autowired
    private ImagensRepository imagensRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Imagens> listarImagens() {
        return imagensRepository.findAll();
    }

    public Imagens inserir(Long id_produto, MultipartFile file) {
        Produto produto = produtoRepository.findById(id_produto).get();
        Imagens imagens = new Imagens();

        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();
                Path caminho = Paths
                        .get("C:\\Users\\railan-santos\\OneDrive\\Desktop\\Imagens\\" + nomeImagem);
                Files.write(caminho, bytes);

                imagens.setNome(nomeImagem);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        imagens.setProduto(produto);
        imagens.setDataCriacao(new Date());
        imagens = imagensRepository.saveAndFlush(imagens);
        return imagens;
    }

    public Imagens alterar(Imagens imagens) {
        imagens.setDataAtualizacao(new Date());
        Imagens ImagensNovas = imagensRepository.saveAndFlush(imagens);
        return ImagensNovas;
    }

    public void excluir(Long id) {
        Imagens imagens = imagensRepository.findById(id).get();
        imagensRepository.delete(imagens);
    }
}
