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
    private Batalha battle = new Batalha();
	
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
		} else {
			System.out.println("---------------------------------------");
	    	System.out.println("---------------------------------------");
	    	for(Personagem p : personagens) {
	    		p.mostrarDados();
	    		System.out.println("---------------------------------------");
	    	}
	    	System.out.println("---------------------------------------");
		}
                
                System.out.println("Pressione ENTER para continuar...");
                new java.util.Scanner(System.in).nextLine();
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
				List<Personagem> backup = new ArrayList<>(personagens);
				List<Personagem> lutadores = new ArrayList<>();
				Personagem atual = null;
				boolean entrarNaBatalha = false;
				int choice = -1;
				while(entrarNaBatalha == false) {
						System.out.println("\nSelecione os personagens que irão batalhar:\n");
							int cond = 1;
							System.out.println("\n------------------------------------");
							for(Personagem pers : backup) {
								System.out.println("\n" + cond + " - " + pers.getNomeChar());
								cond += 1;
							}
							System.out.println("\n------------------------------------\n");
							choice = sc.nextInt();
							while(true) {
								if(((choice - 1) < 0) || ((choice-1) > backup.size())) {
									System.out.print("\nDigite um valor dentro do intervalo!!\n");
									System.out.println("\nSelecione os personagens que irão batalhar:\n");
									cond = 1;
									System.out.println("\n------------------------------------");
									for(Personagem pers : backup) {
										System.out.println("\n" + cond + " - " + pers.getNomeChar());
										cond += 1;
									}
									System.out.println("\n------------------------------------\n");
									choice = sc.nextInt();
								} else {
									break;
								}
							}
							
							int auxx = -1;
							
							if(!lutadores.isEmpty()) {
								for(int i = 0; i<lutadores.size(); i++) {
									if(backup.get(choice-1).getNomeChar().equals(lutadores.get(i).getNomeChar())) {
										auxx = 1;
									}
								}
							}
							if(auxx == 1) {
								System.out.println("\nPersonagem já carregado no jogo!!\n");
								System.out.println("\nEscolha um válido!!\n");
							} else {
								System.out.println("\n\nPersonagem adicionado a batalha!\n\n");
								atual = backup.get(choice-1);
								lutadores.add(atual);
								backup.remove(choice-1);
							}
							
							if(!backup.isEmpty()) {
								System.out.println("\nDeseja adicionar mais algum personagem à batalha? (1 - Sim) (2 - Não)\n");
								int decision = sc.nextInt();
								
								while(true) {
									if(decision == 1 || decision == 2) {
										break;
									} else {
										System.out.println("\nValor inválido. Digite um valor dentro do intervalo!\n");
										System.out.println("\nDeseja adicionar mais algum personagem à batalha? (1 - Sim) (2 - Não)\n");
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
									System.out.println("Pressione ENTER para continuar...");
							        new java.util.Scanner(System.in).nextLine();
								}
								
								if(entrarNaBatalha == true) {
									List<Personagem> bonecos = new ArrayList<>(); 
                                                                
                                                               for(int i = 0; i<=lutadores.size()-1; i++){
                                                                 if(lutadores.get(i).getTipo().toString().equals("MAGO")) {
                                                                    bonecos.add(new Mago(lutadores.get(i).getNomeChar()));
                                                                } else if(lutadores.get(i).getTipo().toString().equals("TANQUE")) {
                                                                    bonecos.add(new Tanque(lutadores.get(i).getNomeChar()));
                                                                } else if(lutadores.get(i).getTipo().toString().equals("LUTADOR")) {
                                                                    bonecos.add(new Lutador(lutadores.get(i).getNomeChar()));
                                                                } else {
                                                                    bonecos.add(new Assassino(lutadores.get(i).getNomeChar()));
                                                                }
                                                                }
                                                                 
                                                                battle.Batalhar(bonecos);
                                                                
								}
							} else {
								System.out.println("\nNão existem mais personagens para serem adicionados a batalha!\n");
								System.out.println("\nDeseja iniciar a batalha? (1 - Sim) (2 - Não)\n");
								int lek = sc.nextInt();
								while(true) {
									if(lek == 1 || lek == 2) {
										break;
									} else {
										System.out.println("\nDigite um valor válido!\n");
										System.out.println("\nNão existem mais personagens para serem adicionados a batalha!\n");
										System.out.println("\nDeseja iniciar a batalha? (1 - Sim) (2 - Não)\n");
										lek = sc.nextInt();
									}
								}
								if (lek == 1) {
									entrarNaBatalha = true;
									System.out.println("\nADENTRANDO NOS CAMPOS DE BATALHA!!\n");
									System.out.println("Pressione ENTER para continuar...");
							        new java.util.Scanner(System.in).nextLine();
									List<Personagem> bonecos = new ArrayList<>(); 
                                                                
                                                               for(int i = 0; i<=lutadores.size()-1; i++){
                                                                 if(lutadores.get(i).getTipo().toString().equals("MAGO")) {
                                                                    bonecos.add(new Mago(lutadores.get(i).getNomeChar()));
                                                                } else if(lutadores.get(i).getTipo().toString().equals("TANQUE")) {
                                                                    bonecos.add(new Tanque(lutadores.get(i).getNomeChar()));
                                                                } else if(lutadores.get(i).getTipo().toString().equals("LUTADOR")) {
                                                                    bonecos.add(new Lutador(lutadores.get(i).getNomeChar()));
                                                                } else {
                                                                    bonecos.add(new Assassino(lutadores.get(i).getNomeChar()));
                                                                }
                                                                }
                                                                 
                                                                battle.Batalhar(bonecos);

								} else {
									entrarNaBatalha = true;
									System.out.println("\nVocê será redirecionado ao menu principal.\n");
									System.out.println("Pressione ENTER para continuar...");
							        new java.util.Scanner(System.in).nextLine();
								}
							}
				}
				
				} catch (Exception e) {
				System.out.println("\nErro ao iniciar a batalha!\n");
				System.out.println("Pressione ENTER para continuar...");
				new java.util.Scanner(System.in).nextLine();
			}
				} else {
				System.out.println("\nPersonagens insuficientes para uma batalha! Carregue mais personagens para iniciar uma batalha.\n");
				System.out.println("Pressione ENTER para continuar...");
	            new java.util.Scanner(System.in).nextLine();
			}
		}

    public void restaurar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void editarPersonagemBatalha(Personagem k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	}
	

