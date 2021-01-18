package rpg.batalha;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import rpg.personagens.Personagem;
import java.util.Collections;

public class Batalha {
    private List <Personagem> lutadores = new ArrayList<>();
    //private List <Personagem> backup = new ArrayList<>(lutadores);
    
    
    public Batalha() {
	}

    @SuppressWarnings("resource")
	public void Batalhar(List<Personagem> personagens) {
        this.lutadores = (List<Personagem>) personagens;
        //LISTANDO TODOS OS GUERREIROS CARREGADOS NO VETOR LUTADORES
        System.out.println("\nOS GUERREIROS A LUTAR SERÃƒO:\n");
        for(Personagem i: lutadores){
            System.out.println(i.getNomeChar() + " -> " + i.getTipo() + "\n");
            System.out.println("Vida: " + i.getPontosDeVida());
            System.out.println("Poder de Habilidade: " +i.getPoderDeHabilidade());
            System.out.println("Poder de Ataque: " +i.getPoderAtaqueFisico());
            System.out.println("Ataque Básico: " +i.getAtaqueBasico());
            System.out.println("Ataque Especial: " +i.getAtaqueEspecial());
            System.out.println("Armadura: " +i.getArmadura());
            System.out.println("Resistência Mágica: " +i.getResistenciaMagica()+ "\n----------------------\n");
            
        }
        
         System.out.println("\nDeseja iniciar a luta?\n1 - Iniciar.\n2 - Cancelar.");
         Scanner entrada = new Scanner(System.in);
         int op = entrada.nextInt();
         //VERIFICANDO SE O USUARIO NAO FUGIU DO ESCOPO DA PERGUNTA
         while(true){
             if(op <= 2 && op >0){
                break;
            } else {
                System.out.println("Digite um valor dentro do intervalo...");
                }
                op = entrada.nextInt();
         }
         
         //SWITCH CASE PRINCIPAL, CONTENDO MAIS 5 OUTROS SWITCH CASE, BASEADOS NA IDEIA DO JOGO
        switch(op){
            case 1:
                //VERIFICANDO SE EXISTEM MAIS PERSONAGENS DO QUE 1 PARA INICIAR A BATALHA, SE NÃƒO, A FUNÃ‡ÃƒO BATALHAR Ã‰ QUEBRADA
                if(lutadores.size() <= 1){
                    System.out.println("\nGuerreiros insuficientes para iniciar a batalha. Retornando ao lobby...\n\n");
                    break;
                }
                
                System.out.println("READY?");
                int rounds = 1;
                
                //LOOP PARA ENGLOBAR TODOS OS ROUNDS COM CONDIÃ‡ÃƒO DE QUEBRA BASEADA EM UM IF QUE VERIFICA O TAMANHO DO VETOR DOS LUTADORES.
                //SE O VETOR LUTADORES TIVER UM SIZE == 1, ENTAO, SO RESTOU UM GUERREIRO VIVO, LOGO, ELE Ã‰ O CAMPEÃƒO.
                while(true){
                    int tamanho = lutadores.size() - 1;
                    //IF QUE QUEBRA O WHILE TRUE
                    if(tamanho == 0){
                        break;
                    }
                    
                    System.out.println("\n-------------- *ROUND* " + rounds + " --------------");
                    //FUNÃ‡ÃƒO DE SORTEIO
                    Collections.shuffle(lutadores); 
                    System.out.println("\nSorteando a ordem de jogada: ");
                    
                    //LISTANDO TODOS OS GUERREIROS *SORTEADOS*
                    for(int i = 0; i <= tamanho; i++){
                        System.out.println(i+1 + " - " + lutadores.get(i).getNomeChar());
                    }
                    
                    System.out.println("Pressione ENTER para continuar...");
                    new java.util.Scanner(System.in).nextLine();
                    
                    //FOR RESPONSÃ�VEL POR FAZER COM QUE CADA GUERREIRO JOGUE NO ROUND
                    for(int i = 0; i <= tamanho; i++){ // round ja iniciado
                      if(lutadores.get(i).getPontosDeVida() > 0){  
                        System.out.println("É a vez do guerreiro " + lutadores.get(i).getNomeChar());
                        System.out.println("O que ele fará?\n\n1 - Atacar um guerreiro.\n2 - Aprimorar Defesa.\n3 - PowerUp (Carregar habilidade especial).");
                        int atacado = entrada.nextInt();
                        while(true){
                                if(atacado <= 3 && atacado >0){
                                   break;
                                } else {
                                   System.out.println("Digite um valor dentro do intervalo...");
                                   }
                                   atacado = entrada.nextInt();
                                }
                        
                        //VERIFICANDO QUAL OPÃ‡ÃƒO O GUERREIRO SELECIONOU
                        switch(atacado){
                            //ATAQUE
                            case 1:
                                System.out.println("Qual outro guerreiro este " + lutadores.get(i).getTipo() + " irá atacar?\n");
                                //removendo o guerreiro que irÃ¡ atacar do vetor e para listar os suscetives ao ataque
                                List <Personagem> listaDeGuerreiros = new ArrayList<>(lutadores); 
                                listaDeGuerreiros.remove(i);
                                
                                //VERIFICANDO SE EXISTE ALGUM GUERREIRO MORTO PARA NAO SER OPÃ‡ÃƒO DE ATAQUE
                                try{
                                for(int o = 0; o <= listaDeGuerreiros.size(); o++){
                                    if(listaDeGuerreiros.get(o).getPontosDeVida() <= 0){
                                        listaDeGuerreiros.remove(o);
                                        break;
                                    }
                                }}
                                catch(Exception e){
                                    //apenas ignroando o erro que darÃ¡ de index
                                }
                                int sizeGuerreiros = listaDeGuerreiros.size();
                                
                                //listando guerreiros suscetiveis ao ataque
                                try{
                                for(int o = 0; o <= sizeGuerreiros; o++){
                                    System.out.println(o+1 + " - " + listaDeGuerreiros.get(o).getNomeChar() + " -> " + listaDeGuerreiros.get(o).getTipo());
                                }}
                                catch(Exception e){}
                                    
                                //quem atacarÃ¡?
                                int attack = entrada.nextInt();
                                while(true){
                                    if(attack <= sizeGuerreiros && attack >0){
                                       break;
                                    } else {
                                       System.out.println("Digite um valor dentro do intervalo...");
                                       }
                                       attack = entrada.nextInt();
                                    }
                                    
                                    //ARMAZENANDO O GUERREIRO QUE SERÃ� ATACADO BASEADO NA ESCOLHA DO INDEX DENTRO DO VETOR LISTADEGUERREIROS
                                    //DECLARADO NA LINHA 98
                                    Personagem sobAtaque = listaDeGuerreiros.get(attack-1);
                                        
                                    System.out.println("Qual ataque você quer realizar?\n1 - Ataque Padrão\n2 - Ataque Especial\n");
                                    int typeOfAtt = entrada.nextInt();
                                    
                                    //VERIFICANDO SE A RESPOSTA DO USUÃ�RIO NAO FUGIU DO ESCOPO DO PROGRAMA
                                    while(true){
                                        if(typeOfAtt <= 2 && typeOfAtt >0){
                                            break;
                                        } else {
                                            System.out.println("Digite um valor dentro do intervalo...");
                                        }
                                        typeOfAtt = entrada.nextInt();
                                    }
                                    
                                    switch(typeOfAtt){
                                        //ATAQUE PADRÃO
                                        case 1:
                                            //compensar os ataques nas vidas
                                            //exibir os status
                                        	int tipoAtaquePadrao;
                                        	if(lutadores.get(i).getPoderAtaqueFisico() > lutadores.get(i).getPoderDeHabilidade()) {
                                        		tipoAtaquePadrao = 1;
                                        	} else {
                                        		tipoAtaquePadrao = 2;
                                        	}
                                            while(true){
                                                if(tipoAtaquePadrao <= 2 && tipoAtaquePadrao >0){
                                                    break;
                                                } else {
                                                    System.out.println("Digite um valor dentro do intervalo...");
                                                }
                                                tipoAtaquePadrao = entrada.nextInt();
                                            }
                                            switch(tipoAtaquePadrao){
                                                //ATAQUE PADRÃƒO COM DANO FÃ�SICO
                                                case 1:
                                                    System.out.println("\n\n" + lutadores.get(i).getNomeChar() + " ESTÁ ATACANDO " + sobAtaque.getNomeChar() + " COM SEU ATAQUE: " + sobAtaque.getAtaqueBasico() + "\n");
                                                    float calculo = lutadores.get(i).getPoderAtaqueFisico() * (1 - (sobAtaque.getArmadura()/(sobAtaque.getArmadura() + 100)));
                                                    int verif = (int) calculo;
                                                    if(verif >= 0){
                                                    	System.out.println(lutadores.get(i) + " CAUSOU " + verif + "DE DANO AO " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar());
                                                        sobAtaque.setPontosDeVida(sobAtaque.getPontosDeVida() - verif);
                                                    } else {
                                                        System.out.println("\n\n" + sobAtaque.getNomeChar() + " RESISTIU AO ATAQUE DEVIDO A SUA ARMADURA!\n");
                                                    }
                                                    break;
                                                //ATAQUE PADRÃƒO COM PODER DE HABILIDADE
                                                case 2:
                                                    System.out.println("\n\n" + lutadores.get(i).getNomeChar() + " ESTÁ ATACANDO " + sobAtaque.getNomeChar() + " COM SEU ATAQUE: " + sobAtaque.getAtaqueBasico() +"\n");
                                                    float calculo2 = lutadores.get(i).getPoderDeHabilidade() * (1 - (sobAtaque.getResistenciaMagica()/(sobAtaque.getResistenciaMagica()+100)));
                                                    int verif2 = (int) calculo2;
                                                    if(verif2 >= 0){
                                                    	System.out.println(lutadores.get(i) + " CAUSOU " + verif2 + "DE DANO AO " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar());
                                                        sobAtaque.setPontosDeVida(sobAtaque.getPontosDeVida() - verif2);
                                                    } else {
                                                        System.out.println("\n\n" + sobAtaque.getNomeChar() + " RESISTIU AO ATAQUE DEVIDO A SUA RESISTÊNCIA MÁGICA!" + "\n");
                                                    }
                                                   break; 
                                            }
                                            
                                            System.out.println("Pressione ENTER para continuar...");
                                            new java.util.Scanner(System.in).nextLine();
                                            
                                            System.out.println("\n******************************");
                                            System.out.println("\n\nExibindo dados dos guerreiros envolvidos no ataque:\n");
                                            System.out.println("\nATACANTE:\n");
                                            lutadores.get(i).mostrarDados();
                                            System.out.println("\nATACADO:\n");
                                            //VERIFICANDO SE O JOGADOR SOBATAQUE MORREU, LOGO, OBTEVE UMA VIDA NEGATIVA OU IGUAL A 0
                                            if(sobAtaque.getPontosDeVida() <= 0){
                                                    System.out.println(sobAtaque.getNomeChar() + " NÃO RESISTIU AO ATAQUE E FOI DESSA PRA MELHOR! PRESS F\n");
                                                } else {
                                                   sobAtaque.mostrarDados();
                                            }
                                            System.out.println("\n******************************");
                                            break;
                                        //ATAQUE ESPECIAL  
                                        case 2:
                                            //compensar os ataques nas vidas
                                            //exibir os status
                                            //VERIFICAR SE ESTÃ� COM A ULT PRONTA SE NAO, OBRIGA O USUARIO A REALIZAR UM ATAQUE PADRÃƒO PELA FUNÃ‡ÃƒO CATCH(TRY)
                                            
                                            // 0 - poderAtaqueFisicoEspecial
                                            // 1 - poderDeHabilidadeEspecial
                                                System.out.println("\n\n" + lutadores.get(i).getNomeChar() + " IRÁ ATACAR " + sobAtaque.getNomeChar() + " COM SEU ATAQUE " + lutadores.get(i).getAtaqueEspecial());
                                                lutadores.get(i).ataqueEspecial();
                                                
                                                //TENTARÃ� ACESSAR O VETOR RETORNADO DO ATAQUE ESPECIAL, CASO NÃƒO HAJA DADOS NO VETOR, O ATAQUE ESPECIAL
                                                //NÃƒO ACONTECEU, LOGO, CAIRÃ� NO CATCH
                                                try {
                                                float calculo = lutadores.get(i).getAtaqueDoAtaqueEspecial().get(0) * (1 - (sobAtaque.getArmadura()/(sobAtaque.getArmadura() + 100)));
                                                int verificacao = (int) calculo;
                                                float calculo2 = lutadores.get(i).getAtaqueDoAtaqueEspecial().get(1) * (1 - (sobAtaque.getResistenciaMagica()/(sobAtaque.getResistenciaMagica()+100)));
                                                int verificacao2 = (int) calculo2;
                                                
                                                if(verificacao >= 0){
                                                	System.out.println(lutadores.get(i) + " CAUSOU " + verificacao + "DE DANO AO " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar() + "!!!");
                                                    sobAtaque.setPontosDeVida(sobAtaque.getPontosDeVida() - verificacao);
                                                } else {
                                                    System.out.println("\n\n" + sobAtaque.getNomeChar() + " RESISTIU AO ATAQUE FÍSICO DEVIDO A SUA ARMADURA!\n");
                                                }
                                                if(verificacao2 >= 0){  
                                                	System.out.println(lutadores.get(i) + " CAUSOU " + verificacao2 + "DE DANO AO " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar() + "!!!!");
                                                    sobAtaque.setPontosDeVida(sobAtaque.getPontosDeVida() - verificacao2);
                                                } else {
                                                    System.out.println("\n\n" + sobAtaque.getNomeChar() + " RESISTIU AO ATAQUE MÁGICO DEVIDO A SUA RESISTÊNCIA MÃ�GICA!\n");
                                                }
                                                //AQUI INFORMAREMOS QUE O USUÃ�RIO NAO TEM PONTOS DE HABILIDADE SUFICIENTE PARA REALIZAR O ATAQUE ESPECIAL
                                                //DANDO A OPÃ‡ÃƒO DE O MESMO ESCOLHER O TIPO DE ATAQUE PADRÃƒO.
                                                } catch(Exception e) {
                                                    System.out.println("Sem pontos de habilidade para realizar o Ataque Especial. Realize o ataque padrão!\n1 - Ataque Padrão\n");
                                    
                                                        int typeOfAtt2 = entrada.nextInt();

                                                        while(true){
                                                            if(typeOfAtt2 == 1){
                                                                break;
                                                            } else {
                                                                System.out.println("Digite um valor dentro do intervalo...");
                                                            }
                                                            typeOfAtt2 = entrada.nextInt();
                                                        }
                                                        switch(typeOfAtt2){
                                                            case 1:
                                                                //compensar os ataques nas vidas
                                                                //exibir os status
                                                            	int tipoAtaquePadrao2;
                                                                if(lutadores.get(i).getPoderAtaqueFisico() > lutadores.get(i).getPoderDeHabilidade()) {
                                                                	tipoAtaquePadrao2 = 1;
                                                                } else {
                                                                	tipoAtaquePadrao2 = 2;
                                                                }
                                                                while(true){
                                                                    if(tipoAtaquePadrao2 <= 2 && tipoAtaquePadrao2 >0){
                                                                        break;
                                                                    } else {
                                                                        System.out.println("Digite um valor dentro do intervalo...");
                                                                    }
                                                                    tipoAtaquePadrao = entrada.nextInt();
                                                                }
                                                                switch(tipoAtaquePadrao2){
                                                                        case 1:
                                                                            System.out.println("\n\n" + lutadores.get(i).getNomeChar() + " ESTÁ ATACANDO " + sobAtaque.getNomeChar() + " COM SEU ATAQUE " + sobAtaque.getAtaqueBasico());
                                                                            float calculo = lutadores.get(i).getPoderAtaqueFisico() * (1 - (sobAtaque.getArmadura()/(sobAtaque.getArmadura() + 100)));
                                                                            int verif = (int) calculo;
                                                                            if(verif >= 0){    
                                                                                sobAtaque.setPontosDeVida(sobAtaque.getPontosDeVida() - verif);
                                                                            } else {
                                                                                System.out.println("\n\n" + sobAtaque.getNomeChar() + " RESISTIU AO ATAQUE DEVIDO A SUA ARMADURA!\n");
                                                                            }
                                                                            break;
                                                                        case 2:
                                                                            System.out.println("\n\n" + lutadores.get(i).getNomeChar() + " ESTÁ ATACANDO COM MAGIA O(A) " + sobAtaque.getNomeChar());
                                                                            float calculo2 = lutadores.get(i).getPoderDeHabilidade() * (1 - (sobAtaque.getResistenciaMagica()/(sobAtaque.getResistenciaMagica()+100)));
                                                                            int verif2 = (int) calculo2;

                                                                            if(verif2 >= 0){
                                                                                sobAtaque.setPontosDeVida(sobAtaque.getPontosDeVida() - verif2);
                                                                            } else {
                                                                                System.out.println("\n\n" + sobAtaque.getNomeChar() + " RESISTIU AO ATAQUE DEVIDO A SUA RESISTÊNCIA MÁGICA!");
                                                                            }
                                                                           break; 

                                                                        }
                                                                break;
                                                                    }
                                                                }
                                                
                                                System.out.println("Pressione ENTER para continuar...");
                                                new java.util.Scanner(System.in).nextLine();
                                                
                                                //EXIBINDO OS DANOS E PONTOS DE HABILIDADE
                                                System.out.println("\n******************************");
                                                System.out.println("\n\nSTATUS DOS GUERREIROS APÓS ATAQUE ESPECIAL: ");
                                                System.out.println("\nATACANTE:\n");
                                                lutadores.get(i).mostrarDados();
                                                System.out.println("\nATACADO:\n");
                                                if(sobAtaque.getPontosDeVida() <= 0){
                                                    System.out.println(sobAtaque.getNomeChar() + " NÃO RESISTIU AO ATAQUE E FOI DESSA PRA MELHOR! PRESS F\n");
                                                } else {
                                                    sobAtaque.mostrarDados();
                                                }
                                                System.out.println("\n******************************");
                                                
                                                break;
                                    }
                                    
                                    
                                    
                                    System.out.println("Pressione ENTER para continuar...");
                                    new java.util.Scanner(System.in).nextLine();
                                    
                                    break;
                            //APRIMORANDO DEFESA
                            case 2:
                                System.out.println("Qual tipo de defesa deseja aprimorar?\n\n1 - Resistência Mágica\n2 - Armadura\n");
                                
                                int tipoDefesa = entrada.nextInt();
                                while(true){
                                        if(tipoDefesa <= 2 && tipoDefesa >0){
                                            break;
                                        } else {
                                            System.out.println("Digite um valor dentro do intervalo...");
                                        }
                                        tipoDefesa = entrada.nextInt();
                                    }
                                
                                switch(tipoDefesa){
                                    case 1:
                                        lutadores.get(i).setResistenciaMagica(lutadores.get(i).getResistenciaMagica() + 5);
                                        break;
                                    case 2:
                                        lutadores.get(i).setArmadura(lutadores.get(i).getArmadura() + 5);
                                        break;
                                }
                                
                                System.out.println(lutadores.get(i).getNomeChar() + " está aprimorando a sua defesa para os próximos rounds!\n");
                                
                                
                                
                                System.out.println("Pressione ENTER para continuar...");
                                new java.util.Scanner(System.in).nextLine();
                                
                                
                                lutadores.get(i).mostrarDados();
                                System.out.println("\n");
                                
                                System.out.println("Pressione ENTER para continuar...");
                                new java.util.Scanner(System.in).nextLine();
                                
                                break;
                            //REALIZANDO POWERUP    
                            case 3:
                                System.out.println("\n*****O guerreiro " + lutadores.get(i).getNomeChar() + " está upando suas habilidades!*****\n");
                                lutadores.get(i).powerUp();
                                lutadores.get(i).mostrarDados();
                                System.out.println("\n******************************");
                                System.out.println("\n");
                                System.out.println("Pressione ENTER para continuar...");
                                new java.util.Scanner(System.in).nextLine();
                                
                                break;
                            }
                        } else {
                            //TENDO EM VISTA QUE SÃ“ Ã‰ POSSÃ�VEL
                            //MORRER UM GUERREIRO POR ROUND, O FOR Ã‰ QUEBRADO.
                            System.out.println("\nSeria a vez do guerreiro " + lutadores.get(i).getNomeChar() + ", mas ele era fraco demais e faleceu. Press f to pay respect!\nPulando a vez!\n\n");
                            System.out.println("Pressione ENTER para continuar...");
                            new java.util.Scanner(System.in).nextLine();
                        }
                    }
                    //INCREMENTANDO OS ROUNDS. O NÃšMERO DE ROUNDS Ã‰ INDETERMINADO POIS A BATALHA SÃ“ ACABA QUANDO RESTA
                    //UM GUERREIRO VIVO
                    rounds++;   
                    int tamanhoRemocao = lutadores.size() - 1;
                        for(int k=0; k<= tamanhoRemocao; k++){
                            if(lutadores.get(k).getPontosDeVida() <= 0){
                                lutadores.remove(lutadores.get(k));
                                break;
                                }
                            }
                }
                
                   // restaurar(backup);
                break;
            //CANCELANDO A BATALHA    
            case 2:
            	System.out.println("Saindo para o lobby...");
                System.out.println("Pressione ENTER para continuar...");
                new java.util.Scanner(System.in).nextLine();
            	break;
            //QUALQUER COISA DIFERENTE DO INTERVALO DA PERGUNTA, O QUE RETORNA PARA O LOBBY    
            case 0:
                System.out.println("Comando inválido, retornando ao lobby...");
                System.out.println("Pressione ENTER para continuar...");
                new java.util.Scanner(System.in).nextLine();
                break;
        	}
        //CASO HAJA APENAS UM PERSONAGEM NO VETOR, ELE FOI O CAMPEÃƒO, LOGO, AQUI A SUA APRESENTAÃ‡ÃƒO.
        if(lutadores.size() == 1){
            System.out.println("\n\n\n\n");
            System.out.println("\n**************CAMPEÃO****************\n");
            System.out.println("O(A)" + lutadores.get(0).getNomeChar() + " FOI O GRANDE CAMPEÃO!!!!!\n");
            System.out.println("\n******************************");
            System.out.println("Pressione ENTER para continuar...");
                new java.util.Scanner(System.in).nextLine();
        }
    }

	//public void restaurar(List p){
      //  this.lutadores = p;
   // }
    
}
