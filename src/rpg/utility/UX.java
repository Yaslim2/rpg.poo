package rpg.utility;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import rpg.batalha.Batalha;
import rpg.personagens.Assassino;
import rpg.personagens.Lutador;
import rpg.personagens.Mago;
import rpg.personagens.Personagem;
import rpg.personagens.Tanque;

public class UX {
	private List <Personagem> personagens = new ArrayList<>();
	private Salvar save = new Salvar();
    private Carregar load = new Carregar();
    private Scanner s = new Scanner(System.in);
    private Boolean pararPrograma = false;
    private Apagar delete = new Apagar();
    private Editar edite = new Editar();
	
	public UX() {}

	public List<Personagem> getPersonagens() {
		return personagens;
	}

	public Salvar getSave() {
		return save;
	}

	public Carregar getLoad() {
		return load;
	}

	public Boolean getPararPrograma() {
		return pararPrograma;
	}
	
	public Apagar getDelete() {
		return delete;
	}

	public Editar getEdite() {
		return edite;
	}

	@SuppressWarnings("resource")
	public void criarPersonagem() {
		String nome;
    	int condition;
    	int condition2;
        System.out.println("\nQual personagem você deseja criar:\n\n1 - Mago\n2 - Tanque\n3 - Lutador\n4 - Assassino\n");
        try {
        	int operation = s.nextInt();
        	switch(operation) {
        	case 1:
        		System.out.print("\nNome do Personagem: ");
        		s.nextLine();
        		nome = s.nextLine();
        		condition = load.nomeJaCriado(nome);
        		condition2 = checaLista(nome);
        		if(condition == 1 || condition2 == 1) {
        			System.out.println("Nome já utilizado!\n");
            		System.out.println("Pressione ENTER para continuar...");
            		new java.util.Scanner(System.in).nextLine();
            		break;
        		} else {
        			personagens.add(new Mago(nome));
            		System.out.println("\n\nPersonagem criado!\n");
            		System.out.println("Pressione ENTER para continuar...");
                    new java.util.Scanner(System.in).nextLine();
            		break;
        		}
        	case 2:
        		System.out.print("\nNome do Personagem: ");
        		s.nextLine();
        		nome = s.nextLine();
        		condition = load.nomeJaCriado(nome);
        		condition2 = checaLista(nome);
        		if(condition == 1 || condition2 == 1) {
        			System.out.println("\n\nNome já utilizado!\n");
            		System.out.println("Pressione ENTER para continuar...");
            		new java.util.Scanner(System.in).nextLine();
            		break;
        		} else {
        			personagens.add(new Tanque(nome));
            		System.out.println("\n\nPersonagem criado!\n");
            		System.out.println("Pressione ENTER para continuar...");
                    new java.util.Scanner(System.in).nextLine();
            		break;
        		}
        	case 3:
        		System.out.print("\nNome do Personagem: ");
        		s.nextLine();
        		nome = s.nextLine();
        		condition = load.nomeJaCriado(nome);
        		condition2 = checaLista(nome);
        		if(condition == 1 || condition2 == 1) {
        			System.out.println("Nome já utilizado!\n");
            		System.out.println("Pressione ENTER para continuar...");
            		new java.util.Scanner(System.in).nextLine();
            		break;
        		} else {
        			personagens.add(new Lutador(nome));
            		System.out.println("\n\nPersonagem criado!\n");
            		System.out.println("Pressione ENTER para continuar...");
                    new java.util.Scanner(System.in).nextLine();
            		break;
        		}
        	case 4:
        		System.out.print("\nNome do Personagem: ");
        		s.nextLine();
        		nome = s.nextLine();
        		condition = load.nomeJaCriado(nome);
        		condition2 = checaLista(nome);
        		if(condition == 1 || condition2 == 1) {
        			System.out.println("Nome já utilizado!\n");
            		System.out.println("Pressione ENTER para continuar...");
            		new java.util.Scanner(System.in).nextLine();
            		break;
        		} else {
        			personagens.add(new Assassino(nome));
            		System.out.println("\n\nPersonagem criado!\n");
            		System.out.println("Pressione ENTER para continuar...");
                    new java.util.Scanner(System.in).nextLine();
            		break;
        		}
        	default:
        		System.out.println("\nPersonagem inexistente!!\n");
        		System.out.println("Pressione ENTER para continuar...");
                new java.util.Scanner(System.in).nextLine();
                break;
        }
      }  catch(InputMismatchException e) {
    	  System.out.println("\nErro ao criar personagem!! Digite um caractere válido.\n");
    	  System.out.println("Pressione ENTER para continuar...");
    	  new java.util.Scanner(System.in).nextLine();
    	  s.nextLine();
      }
        catch(RuntimeException e) {
        	System.out.println("\nErro inesperado!\n");
      	  System.out.println("Pressione ENTER para continuar...");
      	  new java.util.Scanner(System.in).nextLine();
      	  s.nextLine();
        }
        }
        
	
	@SuppressWarnings("resource")
	public void exibirPersonagens() {
		if(personagens.isEmpty()) {
			System.out.println("\nNenhum personagem carregado!\n");
			System.out.println("Pressione ENTER para continuar...");
            new java.util.Scanner(System.in).nextLine();
		} else {
			System.out.println("---------------------------------------");
	    	System.out.println("---------------------------------------");
	    	for(Personagem p : personagens) {
	    		p.mostrarDados();
	    		System.out.println("---------------------------------------");
	    	}
	    	System.out.println("---------------------------------------");
		}
	}
	
	@SuppressWarnings("resource")
	public void salvarPersonagens() {
		if(personagens.isEmpty()) {
			System.out.println("\nSem personagens carregados para salvar!\n");
			System.out.println("Pressione ENTER para continuar...");
            new java.util.Scanner(System.in).nextLine();
		} else {
			for(Personagem p : personagens) {
	        	save.save(p);
	        }
	    	System.out.println("\nPersonagem(s) salvo(s)!\n");
			System.out.println("Pressione ENTER para continuar...");
			new java.util.Scanner(System.in).nextLine();
		}
	}
	
	@SuppressWarnings("resource")
	public void carregarPersonagem() {
		System.out.println();
        Personagem aux = load.selecaoPersonagem();
        if(aux != null) {
        	Integer cond = load.nomeRepetido(personagens, aux);
            if(cond == 1) {
            	System.out.println("\nPERSONAGEM JÁ CARREGADO!!!!\n");
            	System.out.println("Pressione ENTER para continuar...");
            	new java.util.Scanner(System.in).nextLine();
            } else if(cond == 0){
            	personagens.add(aux);
            	System.out.println("\nPersonagem carregado!\n");
                System.out.println("Pressione ENTER para continuar...");
                new java.util.Scanner(System.in).nextLine();
            }
        }
	}
	
	public void listarPersonagensSalvos() {
		load.listarPersonagens();
	}
	
	@SuppressWarnings("resource")
	public void encerrarPrograma() {
		pararPrograma = true;
		System.out.println("\nPrograma encerrado, volte sempre!\n");
		System.out.println("Pressione ENTER para continuar...");
        new java.util.Scanner(System.in).nextLine();
		s.close();
	}
	
	public void deletarPersonagens() {
		Boolean condition = false;
		int aux = 0;
		String pers = delete.pegarNome();
		delete.apagarArquivo(pers);
		if(pers != null) {
			if(!personagens.isEmpty()) {
			
			for(int i = 0; i<personagens.size(); i++) {
				if(personagens.get(i).getNomeChar().equals(pers)) {
					condition = true;
					aux = i;
				}
			}
			if(condition == true) {
				personagens.remove(aux);
			}
		}
		}
	}
	
	public int checaLista(String nome) {
		int cond=0;
		for(int i = 0; i<personagens.size(); i++) {
			if(personagens.get(i).getNomeChar().equals(nome)) {
				cond = 1;
			}
		}
		return cond;
	}
	
	public void editarPersonagem() {
		Personagem p = edite.pegarPersonagem();
		
		Personagem aux = edite.editarPersonagem(p);

		if(!personagens.isEmpty()) {
			edite.editarArray(personagens, p, aux);
		}
	}
	
	@SuppressWarnings("resource")
	public void Batalhar() {
		if(!personagens.isEmpty() && personagens.size() > 1) {
			Scanner sc = new Scanner(System.in);
			try {
				List<Personagem> lutadores = new ArrayList<>();
				boolean entrarNaBatalha = false;
				int choice = -1;
				while(entrarNaBatalha == false) {
						System.out.println("\nSelecione os personagens que irão batalhar:\n");
							int cond = 1;
							for(Personagem pers : personagens) {
								System.out.println("\n" + cond + " - " + pers.getNomeChar());
								cond += 1;
							}
							choice = sc.nextInt();
							while(true) {
								if(((choice - 1) < 0) || ((choice-1) > personagens.size())) {
									System.out.print("\nDigite um valor dentro do intervalo: ");
									System.out.println("\nSelecione os personagens que irão batalhar:\n");
									cond = 1;
									for(Personagem pers : personagens) {
										System.out.println("\n" + cond + " - " + pers.getNomeChar());
										cond += 1;
									}
									System.out.println("\n");
									choice = sc.nextInt();
								} else {
									break;
								}
							}
							
							int auxx = -1;
							
							if(!lutadores.isEmpty()) {
								for(int i = 0; i<lutadores.size(); i++) {
									if(personagens.get(choice-1).getNomeChar().equals(lutadores.get(i).getNomeChar())) {
										auxx = 1;
									}
								}
							}
							if(auxx == 1) {
								System.out.println("\nPersonagem já carregado no jogo!!\n");
								System.out.println("\nEscolha um válido!!\n");
							} else {
								System.out.println("\n\nPersonagem adicionado a batalha!\n\n");
								lutadores.add(personagens.get(choice-1));
							}
							
							System.out.println("\nDeseja adicionar mais algum personagem? (1 - Sim) (2 - Não)\n");
							int decision = sc.nextInt();
							
							while(true) {
								if(decision == 1 || decision == 2) {
									break;
								} else {
									System.out.println("\nValor inválido. Digite um valor dentro do intervalo!\n");
									System.out.println("\nDeseja adicionar mais algum personagem? (1 - Sim) (2 - Não)\n");
									decision = sc.nextInt();
								}
							}
							
							if(decision == 1) {
								continue;
							} else if(lutadores.size() == 1){
								System.out.println("\nSelecione mais personagens para começar uma batalha!\n");
								continue;
							} else {
								entrarNaBatalha = true;
								System.out.println("\nADENTRANDO NOS CAMPOS DE BATALHA!!\n");
							}
							
							if(entrarNaBatalha == true) {
								Batalha battle = new Batalha(lutadores);
							}
				}
				} catch (Exception e) {
				System.out.println("\nErro ao iniciar a batalha!\n");
				System.out.println("Pressione ENTER para continuar...");
				new java.util.Scanner(System.in).nextLine();
			}
				} else {
				System.out.println("\nPersonagens insuficientes para uma batalha!\n");
				System.out.println("Pressione ENTER para continuar...");
	            new java.util.Scanner(System.in).nextLine();
			}
		}
			
	
	public Boolean verificaPersonagens() {
		List<String> p = load.personagensSalvos();
		Boolean condition = false;
		int auxiliar = personagens.size();
		int aux1 = 0;
		for(Personagem k: personagens) {
			for(int i = 0; i<p.size(); i++) {
				if(k.getNomeChar().equals(p.get(i))) {
					aux1 += 1;
				}
			}
		}
		if(auxiliar == aux1) {
			condition = true;
		}
		
		return condition;
	}
	
	//public Boolean condicoesBatalha() {
		//Boolean condition1 = verificaPersonagens();
		
	//}
	}
	

