private static void ManipularLista() {
        ListaEncadeada lista = new ListaEncadeada();
        int opcao;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                    1 - Inserir elemento na lista
                    2 - Remover elemento na lista
                    3 - Exibir primeiro e ultimo elemento na lista
                    4 - Calculo de media e Moda
                    0 - Voltar"""));

            switch (opcao) {
                case 1:// insere elemento na lista
                int elemento = Integer.parseInt(JOptionPane.showInputDialog("Digite o elemento a ser inserido na lista:"));
                int posicao = Integer.parseInt(JOptionPane.showInputDialog("""
                        Em qual posição deseja inserir o elemento?
                        1 - Início
                        2 - Meio
                        3 - Fim"""));
            
                IntNoSimples novoNo = new IntNoSimples(elemento);
            
                switch (posicao) {
                    case 1: // Inserir no início
                        lista.insereNo_inicio(novoNo); //  // Cria um novo nó com o elemento fornecido pelo usuário
                        JOptionPane.showMessageDialog(null, "Elemento inserido no início da lista!");
                        break;
                    case 2: // Inserir no meio
                        int posicaoMeio = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição do elemento no meio da lista:")); // Solicita ao usuário a posição em que deseja inserir o elemento no meio da lista
                        lista.insereNo_posicao(novoNo, posicaoMeio);  // Insere o novo nó na posição informada pelo usuário
                        JOptionPane.showMessageDialog(null, "Elemento inserido no meio da lista!");// mostra que foi colocado no meio da lista
                        break;
                    case 3: // Inserir no fim
                        lista.insereNo_fim(novoNo);
                        JOptionPane.showMessageDialog(null, "Elemento inserido no fim da lista");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "opcao invlida!");
                        break;
                }
            
                break;
                case 2:// remove elementos da lista
                    if (lista.numero_nos == 0) {
                        JOptionPane.showMessageDialog(null, "A lista esta vazia!");
                    } else {
                        // Remove o elemento do início da lista
                        IntNoSimples noRemovido = lista.primeiro;
                        lista.excluiNo(noRemovido.valor);

                        JOptionPane.showMessageDialog(null, "Elemento removido da lista: " + noRemovido.valor);

                    }
                    break;
                case 3: // exibe o primeiro e o ultimo elemento da lista
                    if (lista.numero_nos == 0) {
                        JOptionPane.showMessageDialog(null, "A lista esta vazia!");
                    } else {
                        // Exibe o primeiro elemento da lista
                        IntNoSimples primeiroNo = lista.primeiro; //  Armazena o primeiro elemento da lista na variável primeiroNo
                        JOptionPane.showMessageDialog(null,
                                "Primeiro elemento da lista: Valor " + primeiroNo.valor + ", Posicao 0");

                        // Exibe o último elemento da lista
                        IntNoSimples ultimoNo = lista.ultimo; // Armazena o último elemento da lista na variável ultimoNo
                        int posicaoUltimo = lista.ContarNos() - 1; //Calcula a posição do último elemento da lista, subtraindo 1 do total de nós na lista.
                        JOptionPane.showMessageDialog(null,
                                "Ultimo elemento da lista: Valor " + ultimoNo.valor + ", Posicao " + posicaoUltimo);
                    }
                    break;
                case 4: /// Calculo de media e moda
                    if (lista.numero_nos == 0) { // Verifica se a lista está vazia
                        JOptionPane.showMessageDialog(null, "A lista está vazia!");
                    } else {
                        // Cálculo da média
                        int soma = 0; // Variável para armazenar a soma dos valores
                        IntNoSimples tempNo = lista.primeiro; // Variável para percorrer a lista
                        // Loop para percorrer todos os elementos da lista e calcular a soma
                        while (tempNo != null) {
                            soma += tempNo.valor; // Adiciona o valor do elemento atual à soma
                            tempNo = tempNo.prox; // Avança para o próximo elemento
                        }
                        float media = (float) soma / lista.numero_nos; // Cálculo da média
                        JOptionPane.showMessageDialog(null, "Media dos elementos da lista: " + media);
                        // Cálculo da moda
                        IntNoSimples tempNo2 = lista.primeiro; // Outra variável para percorrer a lista
                        int moda = 0; // Variável para armazenar a moda
                        int modaFrequencia = 0; // Variável para armazenar a frequência da moda
                        // Loop para percorrer todos os elementos da lista e calcular a moda
                        while (tempNo2 != null) {
                            int frequencia = 0; // Variável para armazenar a frequência atual
                            IntNoSimples tempNo3 = lista.primeiro; // Variável auxiliar para percorrer a lista
                            // Loop para contar a frequência do valor atual
                            while (tempNo3 != null) {
                                if (tempNo3.valor == tempNo2.valor) {
                                    frequencia++; // Incrementa a frequência se houver uma correspondência
                                }
                                tempNo3 = tempNo3.prox; // Avança para o próximo elemento
                            }
                            if (frequencia > modaFrequencia) {
                                moda = tempNo2.valor; // Atualiza o valor da moda
                                modaFrequencia = frequencia; // Atualiza a frequência da moda
                            }
                            tempNo2 = tempNo2.prox; // Avança para o próximo elemento
                        }
                        JOptionPane.showMessageDialog(null, "Média dos elementos da lista: " + media + "\n"
                                + "Moda: " + moda + "\n"
                                + "Frequência da moda: " + modaFrequencia);
                    }
                case 0:
                    JOptionPane.showMessageDialog(null, "Voltando...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao invalida!");
            }
        } while (opcao != 0);
