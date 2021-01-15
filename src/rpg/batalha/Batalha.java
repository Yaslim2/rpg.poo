package rpg.batalha;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import rpg.personagens.Personagem;
import java.util.Collections;

public class Batalha {
    private List <Personagem> lutadores = new ArrayList<>();
    //private List <Personagem> backup = new ArrayList<>(lutadores);
    


    public Batalha(List<Personagem> personagens) {
        this.lutadores = (List<Personagem>) personagens;
        
        System.out.println("\nOS GUERREIROS A LUTAR SERÃO:\n");
        for(Personagem i: lutadores){
            System.out.println(i.getNomeChar() + " -> " + i.getTipo() + "\n");
            System.out.println("Vida: " + i.getPontosDeVida());
            System.out.println("Poder de Habilidade: " +i.getPoderDeHabilidade());
            System.out.println("Poder de Ataque: " +i.getPoderAtaqueFisico());
            System.out.println("Ataque Básico: " +i.getAtaqueBasico());
            System.out.println("Ataque Especial: " +i.getAtaqueEspecial());
            System.out.println("Armadura: " +i.getArmadura());
            System.out.println("Resitência Mágica: " +i.getResistenciaMagica()+ "\n----------------------\n");
            
        }
        
         System.out.println("\nDeseja iniciar a luta?\n1 - Iniciar.\n2 - Cancelar.");
         Scanner entrada = new Scanner(System.in);
         int op = entrada.nextInt();
         while(true){
             if(op <= 2 && op >0){
                break;
            } else {
                System.out.println("Digite um valor dentro do intervalo...");
                }
                op = entrada.nextInt();
         }
        switch(op){
            case 1:
                if(lutadores.size() <= 1){
                    System.out.println("\nGuerreiros insuficientes para iniciar a batalha. Retornando ao lobby...\n\n");
                    break;
                }
                
                System.out.println("READY?");
                int rounds = 1;
                
                while(true){
                    int tamanho = lutadores.size() - 1;
                    
                    if(tamanho == 0){
                        break;
                    }
                    System.out.println("\n-------------- *ROUND* " + rounds + " --------------");
                    Collections.shuffle(lutadores); 
                    System.out.println("\nSorteando a ordem de jogada: ");
                    
                    for(int i = 0; i <= tamanho; i++){
                        System.out.println(i+1 + " - " + lutadores.get(i).getNomeChar());
                    }
                    
                    System.out.println("Pressione ENTER para continuar...");
                    new java.util.Scanner(System.in).nextLine();
                    
                    for(int i = 0; i <= tamanho; i++){ // round ja iniciado
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
                        
                        switch(atacado){
                            //atacar
                            case 1:
                                System.out.println("Qual outro guerreiro este " + lutadores.get(i).getTipo() + " irá atacar?\n");
                                //removendo o guerreiro que irá atacar do vetor e para listar os suscetives ao ataque
                                List <Personagem> listaDeGuerreiros = new ArrayList<>(lutadores); 
                                listaDeGuerreiros.remove(i);
                                int sizeGuerreiros = listaDeGuerreiros.size();
                                
                                //listando guerreiros suscetiveis ao ataque
                                try{
                                for(int o = 0; o <= sizeGuerreiros; o++){
                                    System.out.println(o+1 + " - " + listaDeGuerreiros.get(o).getNomeChar() + " -> " + listaDeGuerreiros.get(o).getTipo());
                                }}
                                catch(Exception e){}
                                    
                                //quem atacará?
                                int attack = entrada.nextInt();
                                while(true){
                                    if(attack <= sizeGuerreiros && attack >0){
                                       break;
                                    } else {
                                       System.out.println("Digite um valor dentro do intervalo...");
                                       }
                                       attack = entrada.nextInt();
                                    }
                                
                                Personagem sobAtaque = listaDeGuerreiros.get(attack-1);
                                        
                                    System.out.println("Qual ataque você quer realizar?\n1 - Ataque Padrão\n2 - Ataque Especial\n");
                                    int typeOfAtt = entrada.nextInt();
                                    
                                    while(true){
                                        if(typeOfAtt <= 2 && typeOfAtt >0){
                                            break;
                                        } else {
                                            System.out.println("Digite um valor dentro do intervalo...");
                                        }
                                        typeOfAtt = entrada.nextInt();
                                    }
                                    switch(typeOfAtt){
                                        case 1:
                                            //compensar os ataques nas vidas
                                            //exibir os status
                                            System.out.println("Qual ataque padrão você quer efetuar?\n1 - Ataque Fisico\n2 - Ataque Mágico\n");
                                            int tipoAtaquePadrao = entrada.nextInt();
                                            while(true){
                                                if(tipoAtaquePadrao <= 2 && tipoAtaquePadrao >0){
                                                    break;
                                                } else {
                                                    System.out.println("Digite um valor dentro do intervalo...");
                                                }
                                                tipoAtaquePadrao = entrada.nextInt();
                                            }
                                            switch(tipoAtaquePadrao){
                                                case 1:
                                                    System.out.println("\n\n" + lutadores.get(i).getNomeChar() + " ESTÁ ATACANDO " + sobAtaque.getNomeChar() + " COM SEU ATAQUE " + sobAtaque.getAtaqueBasico() + "\n");
                                                    int verif = (lutadores.get(i).getPoderAtaqueFisico() - sobAtaque.getArmadura());
                                                    if(verif >= 0){    
                                                        sobAtaque.setPontosDeVida(sobAtaque.getPontosDeVida() - verif);
                                                    } else {
                                                        System.out.println("\n\n" + sobAtaque.getNomeChar() + " RESISTIU AO ATAQUE DEVIDO A SUA ARMADURA!\n");
                                                    }
                                                    break;
                                                case 2:
                                                    System.out.println("\n\n" + lutadores.get(i).getNomeChar() + " ESTÁ ATACANDO COM MAGIA O(A) " + sobAtaque.getNomeChar() + "\n");
                                                    int verif2 = (lutadores.get(i).getPoderDeHabilidade() - sobAtaque.getResistenciaMagica());

                                                    if(verif2 >= 0){
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
                                            if(sobAtaque.getPontosDeVida() <= 0){
                                                    System.out.println(sobAtaque.getNomeChar() + " NÃO RESISTIU AO ATAQUE E FOI DESSA PRA MELHOR! PRESS F\n");
                                                } else {
                                                   sobAtaque.mostrarDados();
                                            }
                                            System.out.println("\n******************************");
                                            break;
                                            
                                        case 2:
                                            //compensar os ataques nas vidas
                                            //exibir os status
                                            //VERIFICAR SE ESTÁ COM A ULT PRONTA SE NAO, ATAQUE NORMAL
                                            //lutadores.get(i).ataqueEspecial();
                                            
                                            // 0 - poderAtaqueFisicoEspecial
                                            // 1 - poderDeHabilidadeEspecial
                                            
                                                System.out.println("\n\n" + lutadores.get(i).getNomeChar() + " TENTARÁ APRIMORAR SEUS ATRIBUTOS E IRÁ ATACAR " + sobAtaque.getNomeChar() + " COM SEU ATAQUE " + sobAtaque.getAtaqueEspecial());
                                                lutadores.get(i).ataqueEspecial();
                                                try {
                                                int verificacao = (lutadores.get(i).getAtaqueDoAtaqueEspecial().get(0) - sobAtaque.getArmadura());
                                                int verificacao2 = (lutadores.get(i).getAtaqueDoAtaqueEspecial().get(1) - sobAtaque.getResistenciaMagica());
                                                
                                                if(verificacao >= 0){
                                                    sobAtaque.setPontosDeVida(sobAtaque.getPontosDeVida() - verificacao);
                                                } else {
                                                    System.out.println("\n\n" + sobAtaque.getNomeChar() + " RESISTIU AO ATAQUE FÍSICO DEVIDO A SUA ARMADURA!\n");
                                                }
                                                if(verificacao2 >= 0){    
                                                    sobAtaque.setPontosDeVida(sobAtaque.getPontosDeVida() - verificacao2);
                                                } else {
                                                    System.out.println("\n\n" + sobAtaque.getNomeChar() + " RESISTIU AO ATAQUE MÁGICO DEVIDO A SUA RESISTÊNCIA MÁGICA!\n");
                                                }
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
                                                                System.out.println("Qual ataque padrão você quer efetuar?\n1 - Ataque Fisico\n2 - Ataque Mágico\n");
                                                                int tipoAtaquePadrao2 = entrada.nextInt();
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
                                                                            int verif = (lutadores.get(i).getPoderAtaqueFisico() - sobAtaque.getArmadura());
                                                                            if(verif >= 0){    
                                                                                sobAtaque.setPontosDeVida(sobAtaque.getPontosDeVida() - verif);
                                                                            } else {
                                                                                System.out.println("\n\n" + sobAtaque.getNomeChar() + " RESISTIU AO ATAQUE DEVIDO A SUA ARMADURA!\n");
                                                                            }
                                                                            break;
                                                                        case 2:
                                                                            System.out.println("\n\n" + lutadores.get(i).getNomeChar() + " ESTÁ ATACANDO COM MAGIA O(A) " + sobAtaque.getNomeChar());
                                                                            int verif2 = (lutadores.get(i).getPoderDeHabilidade() - sobAtaque.getResistenciaMagica());

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
                            //defesa
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
                                        lutadores.get(i).setArmadura(lutadores.get(i).getArmadura() + 10);
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
                            //POWERUP    
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
                        
                        
                        
                        //removendo os guerreiros mortos da batalha
                       // for(int k=0; k<= tamanho; k++){
                            if(lutadores.get(i).getPontosDeVida() <= 0){
                                lutadores.get(i).setNomeChar(lutadores.get(i).getNomeChar() + " (MORTO!)");
                            }
                        //}
                        
                        }
                        int tamanhoRemocao = lutadores.size() - 1;
                        
                        try{
                        for(int k=0; k<= tamanhoRemocao; k++){
                            if(lutadores.get(k).getPontosDeVida() <= 0){
                                lutadores.remove(lutadores.get(k));
                            }
                        }}
                        catch(Exception e){
                        }
                        
                        rounds++;
                        
                    }
                
                   // restaurar(backup);
                    


                break;
                
            case 2:
            	System.out.println("Saindo para o lobby...");
                System.out.println("Pressione ENTER para continuar...");
                new java.util.Scanner(System.in).nextLine();
            	break;
                
            case 0:
                System.out.println("Comando inválido, retornando ao lobby...");
                System.out.println("Pressione ENTER para continuar...");
                new java.util.Scanner(System.in).nextLine();
                break;
        	}
         
        if(lutadores.size() == 1){
            System.out.println("AEEEEEEE. O(A)" + lutadores.get(0).getNomeChar() + " FOI O GRANDE VENCEDOR!!!!!");
            System.out.println("Pressione ENTER para continuar...");
                new java.util.Scanner(System.in).nextLine();
        }
    }
    
    
    public void lutar(){
        
    }
    
    
    public void restaurar(List p){
        this.lutadores = p;
    }
    
    
    
}
