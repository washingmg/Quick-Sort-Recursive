# Segurança do Projeto

Este projeto acadêmico é uma implementação do algoritmo **Quick Sort** utilizando recursividade, desenvolvido como parte da disciplina de Projeto e Análise de Algoritmos no curso de Ciência da Computação da UFAL, Campus Arapiraca. 

Embora o projeto não seja uma aplicação crítica de segurança, algumas boas práticas foram consideradas:

## Boas práticas adotadas
- **Código seguro:** O código evita entradas inválidas ou inconsistentes que possam causar erros inesperados, como estouro de pilha em casos de recursão profunda.
- **Validação de dados:** Antes de realizar operações de ordenação, os dados de entrada são verificados quanto ao tipo e consistência.
- **Transparência:** Todo o código, gráficos e imagens são disponibilizados de forma clara para estudo e análise, sem necessidade de acesso a dados sensíveis.

## Considerações de segurança
- Este projeto **não manipula informações pessoais** ou dados críticos.
- O principal risco relacionado à implementação recursiva é **estouro de pilha** (stack overflow) em listas extremamente grandes ou desbalanceadas. Recomenda-se cuidado ao testar com volumes muito altos de dados.
- Para aplicações reais, é recomendada a adoção de limites de recursão ou versões iterativas do algoritmo para evitar falhas de execução.

## Contato
Em caso de dúvidas ou identificação de problemas de segurança relacionados a este projeto, favor entrar em contato com os autores por meio do e-mail institucional: **igor.alencar@arapiraca.ufal.br**, **jhony.santos@arapiraca.ufal.br**, **lucas.farias@arapiraca.ufal.br** e **washington.gaia@arapiraca.ufal.br**