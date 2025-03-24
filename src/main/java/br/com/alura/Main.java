package br.com.alura;

import br.com.alura.model.Produto;
import br.com.alura.service.TraduzProdutoService;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Object> produtos = new CsvToBeanBuilder<>(new FileReader("src/main/resources/products.csv"))
                .withType(Produto.class).build().parse();

        for (Object produto: produtos) {
            System.out.println(produto);
        }

        TraduzProdutoService traducaoService = new TraduzProdutoService();

        for (Object produto: produtos) {
            traducaoService.traduzir((Produto) produto);
            System.out.println(produto);
        }
    }
}