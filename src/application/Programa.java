package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Mapa;
import entities.Robo;

public class Programa {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Mapa mapa = new Mapa(15,19,2,7,18,10);
		double energia = 0;
		while (true) {
			try {
				System.out.print("Insira quanta energia o robô tem (W): ");
				energia = sc.nextDouble();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Insira um numero valido!\n" );
				sc.next();
			}
		}
		Robo bob = new Robo(mapa.getStartPosX()*10, mapa.getStartPosY()*10, energia);
		boolean condicao; 
		String direcao = null;
		int passos = 0;
		
		
		//criacao de paredes no mapa
		for(int i=14-5; i>=14-7; i--) {
			for(int j=0; j<=6; j++) {
				mapa.removerParede(i, j);
			}
		}
		
		for(int i=14-8; i>=14-14; i--) {
			for(int j=4; j<=6; j++) {
				mapa.removerParede(i, j);
			}
		}
		
		for(int i=14-12; i>=14-14; i--) {
			for(int j=7; j<=12; j++) {
				mapa.removerParede(i, j);
			}
		}
		
		for(int i=14-5; i>=14-11; i--) {
			for(int j=10; j<=12; j++) {
				mapa.removerParede(i, j);
			}
		}
		
		for(int i=14-5; i>=14-7; i--) {
			for(int j=13; j<=18; j++) {
				mapa.removerParede(i, j);
			}
		}
		
		for(int i=14-8; i>=14-10; i--) {
			for(int j=16; j<=18; j++) {
				mapa.removerParede(i, j);
			}
		}

		int posicaoRoboXInicial = Math.floorDiv(bob.getPosicaoX(), 10), posicaoRoboYInicial = Math.floorDiv(bob.getPosicaoY(), 10), posicaoRoboXFinal = posicaoRoboXInicial, posicaoRoboYFinal = posicaoRoboYInicial;
		
		//loop jogo
		while (true){
			posicaoRoboYInicial = posicaoRoboYFinal;
			posicaoRoboXInicial = posicaoRoboXFinal;
			int posicaoRoboXInicialIndex = posicaoRoboXInicial - 1;
			int posicaoRoboYInicialIndex = 15-posicaoRoboYInicial;
			int distPercorridaInicial = (int) (bob.getDistPercorrida()*10);
			
			//desenho mapa
			for(int i=0; i<11; i++) {
				for(int j=0; j<19; j++) {
					if(!mapa.paredes[i][j].existe) {
						if(mapa.getWinPosX()-1 == j && 15-mapa.getWinPosY() == i) {
							System.out.print('T');
						} else {
							if(posicaoRoboXInicialIndex == j && posicaoRoboYInicialIndex == i) {
								System.out.print('R');
							} else {
							System.out.print(0);
							}
						}
						} else {
						System.out.print(' ');
					}
					
				}
				System.out.println();
			}
			
			if (bob.getDistPercorrida() == bob.getEnergia()) {
				System.out.println("Acabou a bateria :(");
				System.exit(0);
			}
			
			condicao = true;
			
			//realizar os passos, validando o input
			do {
				
				while (condicao) {
					
			
					try {
						direcao = sc.next().toUpperCase();
						passos = sc.nextInt();
						if(passos>0) {
							condicao = false;
						} else {
							System.out.println("Insira um comando valido!");
						}
					} catch (InputMismatchException e) {
						System.out.println("Insira um comando valido!");
						sc.nextLine();
					} 
				
				}
				
				switch (direcao){
					case "CIMA":
						bob.moveUp(passos);
						posicaoRoboYFinal = (int)(Math.ceil((double)bob.getPosicaoY()/10));
						break;
					case "BAIXO":
						bob.moveDown(passos);
						posicaoRoboYFinal = Math.floorDiv(bob.getPosicaoY(), 10);
						break;
					case "TRAS":
						bob.moveLeft(passos);
						posicaoRoboXFinal = Math.floorDiv(bob.getPosicaoX(), 10);
						break;
					case "FRENTE":
						bob.moveRight(passos);					
						posicaoRoboXFinal = (int)(Math.ceil((double)bob.getPosicaoX()/10));
						break;
					
					default:
						System.out.println("Insira um comando valido!");
						condicao = true;
						break;
				}
			} while (condicao);
			
			int posicaoRoboXFinalIndex = posicaoRoboXFinal - 1;
			int posicaoRoboYFinalIndex = 15-posicaoRoboYFinal;
			
			int deslocamentoX = posicaoRoboXFinalIndex-posicaoRoboXInicialIndex;
			int deslocamentoY = posicaoRoboYFinalIndex-posicaoRoboYInicialIndex;
			
			int distPercorridaFinal = (int) (bob.getDistPercorrida()*10);
			int deslocamentoTotal = distPercorridaFinal - distPercorridaInicial;
			
			//checa se existem paredes no caminho deslocado
			for (int i = posicaoRoboYInicialIndex, countI = Math.abs(deslocamentoY); countI>=0; i+=(Integer.signum(deslocamentoY)), countI--) {
				for (int j = posicaoRoboXInicialIndex, countJ = Math.abs(deslocamentoX); countJ>=0; j+=(Integer.signum(deslocamentoX)), countJ--) {
					if(mapa.paredes[i][j].existe || posicaoRoboYFinalIndex < 0 || posicaoRoboXFinalIndex < 0) {
						System.out.println("\nVoce perdeu!");
						System.exit(0);
					}
				}
			}
			
			System.out.println("\nVoce andou " + deslocamentoTotal + " cm para " + direcao.toLowerCase() + " (" + (Math.abs(deslocamentoX) + Math.abs(deslocamentoY)) + " quadradinho(s)). \n");
			
			
			if (posicaoRoboXFinal == mapa.getWinPosX() && posicaoRoboYFinal == mapa.getWinPosY()) {
				System.out.println("\nVoce chegou ao objetivo!!!");
				System.out.println("Foi usado " + bob.getDistPercorrida() + "W de energia.");
				sc.close();
				System.exit(0);
			}
				
			
			}		
		
		
		}
	
	}


