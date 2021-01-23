package rpg.batalha;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import rpg.personagens.Personagem;
import java.util.Collections;
import java.util.Random;

public class Batalha {
        
        public Batalha() {
            }

        @SuppressWarnings("resource")
	public void Batalhar(List<Personagem> guerreiros) {
            
    	List<Personagem> lutadores = new ArrayList<>(guerreiros); 
        
        //LISTANDO TODOS OS GUERREIROS CARREGADOS NO VETOR LUTADORES
        System.out.println("\nOS GUERREIROS A LUTAR SERAO:\n");
        for(Personagem i: lutadores){
            i.mostrarDados();
            System.out.println("-----------------------\n");
        }
        
        try {
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
                   //VERIFICANDO SE EXISTEM MAIS PERSONAGENS DO QUE 1 PARA INICIAR A BATALHA, SE NAO, A FUNCAO BATALHAR E QUEBRADA
                   if(lutadores.size() <= 1){
                       System.out.println("\nGuerreiros insuficientes para iniciar a batalha. Retornando ao lobby...\n\n");
                       break;
                   }
                   
                   System.out.println("READY?");
                   int rounds = 1;
                   
                   //LOOP PARA ENGLOBAR TODOS OS ROUNDS COM CONDIÃƒâ€¡ÃƒÆ’O DE QUEBRA BASEADA EM UM IF QUE VERIFICA O TAMANHO DO VETOR DOS LUTADORES.
                   //SE O VETOR LUTADORES TIVER UM SIZE == 1, ENTAO, SO RESTOU UM GUERREIRO VIVO, LOGO, ELE Ãƒâ€° O CAMPEÃƒÆ’O.
                   while(true){
                       int tamanho = lutadores.size() - 1;
                       //IF QUE QUEBRA O WHILE TRUE
                       if(tamanho == 0){
                           break;
                       }
                       
                       System.out.println("\n-------------- *ROUND* " + rounds + " --------------");
                       //FUNÃƒâ€¡ÃƒÆ’O DE SORTEIO
                       Collections.shuffle(lutadores); 
                       System.out.println("\nSorteando a ordem de jogada: ");
                       
                       //LISTANDO TODOS OS GUERREIROS *SORTEADOS*
                       for(int i = 0; i <= tamanho; i++){
                           System.out.println(i+1 + " - " + lutadores.get(i).getNomeChar());
                       }
                       
                       System.out.println("Pressione ENTER para continuar...");
                       new java.util.Scanner(System.in).nextLine();
                       
                       //FOR RESPONSAVEL POR FAZER COM QUE CADA GUERREIRO JOGUE NO ROUND
                       for(int i = 0; i <= tamanho; i++){ // round ja iniciado
                         if(lutadores.get(i).getPontosDeVida() > 0){  
                           System.out.println("E a vez do guerreiro " + lutadores.get(i).getNomeChar());
                           System.out.println("O que ele fara?\n\n1 - Atacar um guerreiro.\n2 - Aprimorar Defesa.\n3 - PowerUp (Carregar habilidade especial).");
                           int atacado = entrada.nextInt();
                           while(true){
                                   if(atacado <= 3 && atacado >0){
                                      break;
                                   } else {
                                      System.out.println("Digite um valor dentro do intervalo...");
                                      }
                                      atacado = entrada.nextInt();
                                   }
                           
                           //VERIFICANDO QUAL FUNCAO O GUERREIRO SELECIONOU
                           switch(atacado){
                               //ATAQUE
                               case 1:
                                   System.out.println("Qual outro guerreiro este " + lutadores.get(i).getTipo() + " ira atacar?\n");
                                   //removendo o guerreiro que ira atacar do vetor e para listar os suscetiveis ao ataque
                                   List <Personagem> listaDeGuerreiros = new ArrayList<>(lutadores); 
                                   listaDeGuerreiros.remove(i);
                                   
                                   //VERIFICANDO SE EXISTE ALGUM GUERREIRO MORTO PARA NAO SER PASSIVEL DE ATAQUE
                                   try{
                                   for(int o = 0; o <= listaDeGuerreiros.size(); o++){
                                       if(listaDeGuerreiros.get(o).getPontosDeVida() <= 0){
                                           listaDeGuerreiros.remove(o);
                                           break;
                                       }
                                   }}
                                   catch(Exception e){
                                       //apenas ignorando o erro que dara de index
                                   }
                                   int sizeGuerreiros = listaDeGuerreiros.size();
                                   
                                   //listando guerreiros suscetiveis ao ataque
                                   try{
                                   for(int o = 0; o <= sizeGuerreiros; o++){
                                       System.out.println(o+1 + " - " + listaDeGuerreiros.get(o).getNomeChar() + " -> " + listaDeGuerreiros.get(o).getTipo());
                                   }}
                                   catch(Exception e){}
                                       
                                   //quem atacara?
                                   int attack = entrada.nextInt();
                                   while(true){
                                       if(attack <= sizeGuerreiros && attack >0){
                                          break;
                                       } else {
                                          System.out.println("Digite um valor dentro do intervalo...");
                                          }
                                          attack = entrada.nextInt();
                                       }
                                       
                                       //ARMAZENANDO O GUERREIRO QUE SERAO ATACADO BASEADO NA ESCOLHA DO INDEX DENTRO DO VETOR LISTA DE GUERREIROS
                                       //DECLARADO NA LINHA 98
                                       Personagem sobAtaque = listaDeGuerreiros.get(attack-1);
                                           
                                       System.out.println("Qual ataque você quer realizar?\n1 - Ataque Padrao\n2 - Ataque Especial\n");
                                       int typeOfAtt = entrada.nextInt();
                                       
                                       //VERIFICANDO SE A RESPOSTA DO USUARIO NAO FUGIU DO ESCOPO DO PROGRAMA
                                       while(true){
                                           if(typeOfAtt <= 2 && typeOfAtt >0){
                                               break;
                                           } else {
                                               System.out.println("Digite um valor dentro do intervalo...");
                                           }
                                           typeOfAtt = entrada.nextInt();
                                       }
                                       
                                       switch(typeOfAtt){
                                           //ATAQUE PADRAO
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
                                                   //ATAQUE PADRAO COM DANO FISICO
                                                   case 1:
                                                       Random gerador = new Random();
                                                       int intensidade = gerador.nextInt(4);
                                                       System.out.println("\n\n" + lutadores.get(i).getNomeChar() + " esta atacando " + sobAtaque.getNomeChar() + " com seu ataque: " + sobAtaque.getAtaqueBasico() + "\n");
                                                       float calculo = lutadores.get(i).getPoderAtaqueFisico() * (1 - (sobAtaque.getArmadura()/(sobAtaque.getArmadura() + 100)));
                                                       int verif = (int) (calculo + (intensidade*calculo)/10);
                                                       
                                                       if(verif >= 0){
                                                       	if(intensidade == 0) {
                                                       		System.out.println(lutadores.get(i).getNomeChar() + " causou " + verif + " de dano ao " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar() + " (Ataque Basico)\n");
                                                               lutadores.get(i).ataquePadrao(sobAtaque, verif);
                                                       	} else if(intensidade == 1) {
                                                       		System.out.println(lutadores.get(i).getNomeChar() + " causou " + verif + " de dano ao " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar() + " (Ataque Moderado)\n");
                                                               lutadores.get(i).ataquePadrao(sobAtaque, verif);
                                                       	} else if(intensidade == 2) {
                                                       		System.out.println(lutadores.get(i).getNomeChar() + " causou " + verif + " de dano ao " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar() + " (Ataque Intenso)\n");
                                                               lutadores.get(i).ataquePadrao(sobAtaque, verif);
                                                       	} else {
                                                       		System.out.println("\n*****CRITICO!********\n");
                                                       		System.out.println(lutadores.get(i).getNomeChar() + " causou " + verif + " de dano ao " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar() + " (Ataque Critico)\n");
                                                               lutadores.get(i).ataquePadrao(sobAtaque, verif);
                                                       	}
                                                       } else {
                                                           System.out.println("\n\n" + sobAtaque.getNomeChar() + " resistiu ao ataque devido a sua armadura! Nenhum dano causado!\n");
                                                       }
                                                       break;
                                                   //ATAQUE PADRAO COM PODER DE HABILIDADE
                                                   case 2:
                                                       Random gerador2 = new Random();
                                                       int intensidade2 = gerador2.nextInt(4);
                                                       System.out.println("\n\n" + lutadores.get(i).getNomeChar() + " esta atacando " + sobAtaque.getNomeChar() + " com seu ataque: " + sobAtaque.getAtaqueBasico() +"\n");
                                                       float calculo2 = lutadores.get(i).getPoderDeHabilidade() * (1 - (sobAtaque.getResistenciaMagica()/(sobAtaque.getResistenciaMagica()+100)));
                                                       
                                                       int verif2 = (int) (calculo2 + (intensidade2*calculo2)/10);
                                                       
                                                       if(verif2 >= 0){
                                                       	if(intensidade2 == 0) {
                                                       		System.out.println(lutadores.get(i).getNomeChar() + " causou " + verif2 + " de dano ao " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar() + " (Ataque Basico)\n");
                                                               lutadores.get(i).ataquePadrao(sobAtaque, verif2);
                                                       	} else if(intensidade2 == 1) {
                                                       		System.out.println(lutadores.get(i).getNomeChar() + " causou " + verif2 + " de dano ao " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar() + " (Ataque Moderado)\n");
                                                               lutadores.get(i).ataquePadrao(sobAtaque, verif2);
                                                       	} else if(intensidade2 == 2) {
                                                       		System.out.println(lutadores.get(i).getNomeChar() + " causou " + verif2 + " de dano ao " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar() + " (Ataque Intenso)\n");
                                                               lutadores.get(i).ataquePadrao(sobAtaque, verif2);
                                                       	} else {
                                                       		System.out.println("\n*****CRITICO!********\n");
                                                       		System.out.println(lutadores.get(i).getNomeChar() + " causou " + verif2 + " de dano ao " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar() + " (Ataque Critico)\n");
                                                               lutadores.get(i).ataquePadrao(sobAtaque, verif2);
                                                       	}
                                                       } else {
                                                           System.out.println("\n\n" + sobAtaque.getNomeChar() + " resistiu ao ataque devido a sua resistencia magica! Nenhum dano causado!" + "\n");
                                                       }
                                                      break; 
                                               }
                                               
                                               System.out.println("Pressione ENTER para continuar...");
                                               new java.util.Scanner(System.in).nextLine();
                                               
                                               System.out.println("\n******************************");
                                               System.out.println("\n\nExibindo dados dos guerreiros envolvidos no ataque:\n");
                                               System.out.println("\nAtacante:\n");
                                               lutadores.get(i).mostrarDados();
                                               System.out.println("\nAtacado:\n");
                                               //VERIFICANDO SE O JOGADOR SOBATAQUE MORREU, LOGO, OBTEVE UMA VIDA NEGATIVA OU IGUAL A 0
                                               if(sobAtaque.getPontosDeVida() <= 0){
                                                       System.out.println(sobAtaque.getNomeChar() + " nao resistiu ao ataque e foi dessa para uma melhor! PRESS F\n");
                                                   } else {
                                                      sobAtaque.mostrarDados();
                                               }
                                               System.out.println("\n******************************");
                                               break;
                                           //ATAQUE ESPECIAL  
                                           case 2:
                                               //compensar os ataques nas vidas
                                               //exibir os status
                                               //VERIFICAR SE ESTA COM A ULT PRONTA SE NAO, OBRIGA O USUARIO A REALIZAR UM ATAQUE PADRÃƒÆ’O PELA FUNÃƒâ€¡ÃƒÆ’O CATCH(TRY)
                                               
                                               // 0 - poderAtaqueFisicoEspecial
                                               // 1 - poderDeHabilidadeEspecial
                                                   System.out.println("\n\n" + lutadores.get(i).getNomeChar() + " utilizou " + lutadores.get(i).getAtaqueEspecial() + " e ira atacar " + sobAtaque.getNomeChar() + "!");
                                                   lutadores.get(i).ataqueEspecial(sobAtaque, 0);
                                                   
                                                   //TENTARA ACESSAR O VETOR RETORNADO DO ATAQUE ESPECIAL, CASO NÃƒÆ’O HAJA DADOS NO VETOR, O ATAQUE ESPECIAL
                                                   //NAO ACONTECEU, LOGO, CAIRA NO CATCH
                                                   try {
                                                        Random gerador = new Random();
                                                        int intensidade = gerador.nextInt(4);
                                                        float calculo = lutadores.get(i).getAtaqueDoAtaqueEspecial().get(0) * (1 - (sobAtaque.getArmadura()/(sobAtaque.getArmadura() + 100)));
                                                        int verificacao;
                                                        float calculo2 = lutadores.get(i).getAtaqueDoAtaqueEspecial().get(1) * (1 - (sobAtaque.getResistenciaMagica()/(sobAtaque.getResistenciaMagica()+100)));
                                                   
                                                        if(calculo >= calculo2){
                                                            verificacao = (int) (calculo + (intensidade*calculo)/10);
                                                        } else {
                                                            verificacao = (int) (calculo2 + (intensidade*calculo2)/10);
                                                        }
                                                   
                                                   
                                                   if(verificacao >= 0){
                                                   	if(intensidade == 0) {
                                                   		lutadores.get(i).ataqueEspecial(sobAtaque, verificacao);
                                                                sobAtaque.setPontosDeVida(sobAtaque.getPontosDeVida() - verificacao);
                                                   		System.out.println(lutadores.get(i).getNomeChar() + " causou " + verificacao + " de dano ao " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar() + " (Ataque Especial Basico)\n");
                                                   		
                                                   	} else if(intensidade == 1) {
                                                   		lutadores.get(i).ataqueEspecial(sobAtaque, verificacao);
                                                                sobAtaque.setPontosDeVida(sobAtaque.getPontosDeVida() - verificacao);
                                                   		System.out.println(lutadores.get(i).getNomeChar() + " causou " + verificacao + " de dano ao " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar() + " (Ataque Especial Moderado)\n");
                                                   		
                                                   	} else if(intensidade == 2) {
                                                   		
                                                   		lutadores.get(i).ataqueEspecial(sobAtaque, verificacao);
                                                                sobAtaque.setPontosDeVida(sobAtaque.getPontosDeVida() - verificacao);
                                                   		System.out.println(lutadores.get(i).getNomeChar() + " causou " + verificacao + " de dano ao " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar() + " (Ataque Especial Intenso)\n");
                                                   		
                                                   	} else {
                                                   		lutadores.get(i).ataqueEspecial(sobAtaque, verificacao);
                                                                sobAtaque.setPontosDeVida(sobAtaque.getPontosDeVida() - verificacao);
                                                   		System.out.println("\n*****CRITICO!********\n");
                                                   		System.out.println(lutadores.get(i).getNomeChar() + " causou " + verificacao + " de dano ao " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar() + " (Ataque Especial Critico)\n");
                                                   	}
                                                   } else {
                                                       System.out.println("\n\n" + sobAtaque.getNomeChar() + " resistiu ao ataque fisico com sua armadura! Nenhum dano causado!\n");
                                                   }
                                                  
                                                   //AQUI INFORMAREMOS QUE O USUARIO NAO TEM PONTOS DE HABILIDADE SUFICIENTE PARA REALIZAR O ATAQUE ESPECIAL
                                                   //DANDO A OPCAO DE O MESMO ESCOLHER O TIPO DE ATAQUE PADRAO.
                                                   } catch(Exception e) {
                                                       System.out.println("Sem pontos de habilidade para realizar o Ataque Especial. Realize o ataque padrao!\n1 - Ataque Padrao\n");
                                       
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
                                                                   if(lutadores.get(i).getPoderAtaqueFisico() >= lutadores.get(i).getPoderDeHabilidade()) {
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
                                                                           	Random gerador = new Random();
                                                                               int intensidade = gerador.nextInt(4);
                                                                               System.out.println("\n\n" + lutadores.get(i).getNomeChar() + " esta atacando " + sobAtaque.getNomeChar() + " com seu ataque: " + sobAtaque.getAtaqueBasico());
                                                                               float calculo = lutadores.get(i).getPoderAtaqueFisico() * (1 - (sobAtaque.getArmadura()/(sobAtaque.getArmadura() + 100)));
                                                                               int verif = (int) (calculo + (intensidade*calculo)/10);
                                                                               if(verif >= 0){    
                                                                               	if(intensidade == 0) {
                                                                               		System.out.println(lutadores.get(i).getNomeChar() + " causou " + verif + " de dano ao " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar() + " (Ataque Basico)\n");
                                                                                       lutadores.get(i).ataquePadrao(sobAtaque, verif);
                                                                               	} else if(intensidade == 1) {
                                                                               		System.out.println(lutadores.get(i).getNomeChar() + " causou " + verif + " de dano ao " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar() + " (Ataque Moderado)\n");
                                                                                       lutadores.get(i).ataquePadrao(sobAtaque, verif);
                                                                               	} else if(intensidade == 2) {
                                                                               		System.out.println(lutadores.get(i).getNomeChar() + " causou " + verif + " de dano ao " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar() + " (Ataque Intenso)\n");
                                                                                       lutadores.get(i).ataquePadrao(sobAtaque, verif);
                                                                               	} else {
                                                                               		System.out.println("\n*****CRITICO!********\n");
                                                                               		System.out.println(lutadores.get(i).getNomeChar() + " causou " + verif + " de dano ao " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar() + " (Ataque Critico)\n");
                                                                                       lutadores.get(i).ataquePadrao(sobAtaque, verif);
                                                                               	}
                                                                               } else {
                                                                                   System.out.println("\n\n" + sobAtaque.getNomeChar() + " resistiu ao ataque com sua armadura! Nenhum dano causado\n");
                                                                               }
                                                                               break;
                                                                               
                                                                           case 2:
                                                                           	Random gerador2 = new Random();
                                                                           	int intensidade2 = gerador2.nextInt(4);
                                                                               System.out.println("\n\n" + lutadores.get(i).getNomeChar() + " esta atacando com magia o(a) " + sobAtaque.getNomeChar());
                                                                               float calculo2 = lutadores.get(i).getPoderDeHabilidade() * (1 - (sobAtaque.getResistenciaMagica()/(sobAtaque.getResistenciaMagica()+100)));
                                                                               int verif2 = (int) (calculo2 + (intensidade2*calculo2)/10);

                                                                               if(verif2 >= 0){
                                                                               	if(intensidade2 == 0) {
                                                                               		System.out.println(lutadores.get(i).getNomeChar() + " causou " + verif2 + " de dano ao " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar() + " (Ataque Basico)\n");
                                                                                       lutadores.get(i).ataquePadrao(sobAtaque, verif2);
                                                                               	} else if(intensidade2 == 1) {
                                                                               		System.out.println(lutadores.get(i).getNomeChar() + " causou " + verif2 + " de dano ao " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar() + " (Ataque Moderado)\n");
                                                                                       lutadores.get(i).ataquePadrao(sobAtaque, verif2);
                                                                               	} else if(intensidade2 == 2) {
                                                                               		System.out.println(lutadores.get(i).getNomeChar() + " causou " + verif2 + " de dano ao " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar() + " (Ataque Intenso)\n");
                                                                                       lutadores.get(i).ataquePadrao(sobAtaque, verif2);
                                                                               	} else {
                                                                               		System.out.println("\n*****CRITICO!********\n");
                                                                               		System.out.println(lutadores.get(i).getNomeChar() + " causou " + verif2 + " de dano ao " + sobAtaque.getTipo() + " " + sobAtaque.getNomeChar() + " (Ataque Critico)\n");
                                                                                       lutadores.get(i).ataquePadrao(sobAtaque, verif2);
                                                                               	}
                                                                               } else {
                                                                                   System.out.println("\n\n" + sobAtaque.getNomeChar() + " resistiu ao ataque com sua resistencia magica! Nenhum dano causado!\n");
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
                                                   System.out.println("\n\nSTATUS DOS GUERREIROS APOS ATAQUE ESPECIAL: ");
                                                   System.out.println("\nATACANTE:\n");
                                                   lutadores.get(i).mostrarDados();
                                                   System.out.println("\nATACADO:\n");
                                                   if(sobAtaque.getPontosDeVida() <= 0){
                                                       System.out.println(sobAtaque.getNomeChar() + " nao resistiu ao ataque e foi dessa para uma melhor! PRESS F\n");
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
                                   System.out.println("Qual tipo de defesa deseja aprimorar?\n\n1 - Resistencia Magica\n2 - Armadura\n");
                                   
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
                                           lutadores.get(i).aprimorarDefesa(lutadores.get(i), lutadores.get(i).getResistenciaMagica());
                                           break;
                                       case 2:
                                           lutadores.get(i).aprimorarArmadura(lutadores.get(i), lutadores.get(i).getArmadura());
                                           break;
                                   }
                                   
                                   System.out.println(lutadores.get(i).getNomeChar() + " esta aprimorando a sua defesa para os proximos rounds!\n");
                                   
                                   
                                   
                                   System.out.println("Pressione ENTER para continuar...");
                                   new java.util.Scanner(System.in).nextLine();
                                   
                                   
                                   lutadores.get(i).mostrarDados();
                                   System.out.println("\n");
                                   
                                   System.out.println("Pressione ENTER para continuar...");
                                   new java.util.Scanner(System.in).nextLine();
                                   
                                   break;
                               //REALIZANDO POWERUP    
                               case 3:
                                   System.out.println("\n*****O guerreiro " + lutadores.get(i).getNomeChar() + " esta upando suas habilidades!*****\n");
                                   lutadores.get(i).powerUp();
                                   lutadores.get(i).mostrarDados();
                                   System.out.println("\n******************************");
                                   System.out.println("\n");
                                   System.out.println("Pressione ENTER para continuar...");
                                   new java.util.Scanner(System.in).nextLine();
                                   
                                   break;
                               }
                           } else {
                               //TENDO EM VISTA QUE SO E POSSIVEL
                               //MORRER UM GUERREIRO POR ROUND, O FOR E QUEBRADO.
                               System.out.println("\nSeria a vez do guerreiro " + lutadores.get(i).getNomeChar() + ", mas ele era fraco demais e faleceu. Press f to pay respect!\nPulando a vez!\n\n");
                               System.out.println("Pressione ENTER para continuar...");
                               new java.util.Scanner(System.in).nextLine();
                           }
                       }
                       //INCREMENTANDO OS ROUNDS. O NUMERO DE ROUNDS SAO INDETERMINADOS, POIS A BATALHA SO ACABA QUANDO RESTA
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
                   
                   
                
                break;
               //CANCELANDO A BATALHA    
               case 2:
               	System.out.println("Saindo para o lobby...");
                   System.out.println("Pressione ENTER para continuar...");
                   new java.util.Scanner(System.in).nextLine();
               	break;
               //QUALQUER COISA DIFERENTE DO INTERVALO DA PERGUNTA, O QUE RETORNA PARA O LOBBY    
               case 0:
                   System.out.println("Comando invalido, retornando ao lobby...");
                   System.out.println("Pressione ENTER para continuar...");
                   new java.util.Scanner(System.in).nextLine();
                   break;
           	}
           //CASO HAJA APENAS UM PERSONAGEM NO VETOR, ELE FOI O CAMPEÃƒÆ’O, LOGO, AQUI A SUA APRESENTAÃƒâ€¡ÃƒÆ’O.
           if(lutadores.size() == 1){
               System.out.println("\n\n\n\n");
               System.out.println("\n**************CAMPEAO****************\n");
               System.out.println("O(A)" + lutadores.get(0).getNomeChar() + " FOI O GRANDE CAMPEAO!!!!!\n");
               System.out.println("\n*************************************");
               
               System.out.println("Pressione ENTER para continuar...");
                   new java.util.Scanner(System.in).nextLine();
           }
        } catch (Exception e) {
        	System.out.println("\nErro na batalha!\n");
        	System.out.println("Pressione ENTER para continuar...");
            new java.util.Scanner(System.in).nextLine();
        }
   }
}
