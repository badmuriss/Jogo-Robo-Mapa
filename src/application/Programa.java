package application;

import java.util.Scanner;

import entities.Mapa;
import entities.Parede;
import entities.Robo;

public class Programa {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Mapa mapa = new Mapa(15,19,2,7,18,10);
		Robo bob = new Robo(mapa.getStartPosX()*10, mapa.getStartPosY()*10);
		boolean condicao; 
		String direcao;
		int passos;
		
		
		//criaçao de paredes no mapa
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

		//loop jogo
		while (true){
			
			int posicaoRoboXInicial = Math.floorDiv(bob.getPosicaoX(), 10);
			int posicaoRoboYInicial = Math.floorDiv(bob.getPosicaoY(), 10);

			int posicaoRoboXInicialIndex = posicaoRoboXInicial - 1;
			int posicaoRoboYInicialIndex = 15-posicaoRoboYInicial;
			
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
			
			
			do {
				direcao = sc.next().toUpperCase();
				passos = sc.nextInt();
				condicao = false;
				switch (direcao){
					case "CIMA":
					bob.moveUp(passos);
						break;
					case "BAIXO":
						bob.moveDown(passos);
						break;
					case "TRAS":
						bob.moveLeft(passos);
						break;
					case "FRENTE":
						bob.moveRight(passos);
						break;
					
					default:
						System.out.println("Insira um comando válido!");
						condicao = true;
						break;
				}
			} while (condicao);
			
			int posicaoRoboXFinal = Math.floorDiv(bob.getPosicaoX(), 10);
			int posicaoRoboYFinal = Math.floorDiv(bob.getPosicaoY(), 10);
			
			int posicaoRoboXFinalIndex = posicaoRoboXFinal - 1;
			int posicaoRoboYFinalIndex = 15-posicaoRoboYFinal;
			
			int deslocamentoX = posicaoRoboXFinalIndex-posicaoRoboXInicialIndex;
			int deslocamentoY = posicaoRoboYFinalIndex-posicaoRoboYInicialIndex;
			
			//checa se existem paredes no caminho deslocado
			for (int i = posicaoRoboYInicialIndex, countI = Math.abs(deslocamentoY); countI>=0; i+=(Integer.signum(deslocamentoY)), countI--) {
				for (int j = posicaoRoboXInicialIndex, countJ = Math.abs(deslocamentoX); countJ>=0; j+=(Integer.signum(deslocamentoX)), countJ--) {
					if(mapa.paredes[i][j].existe || posicaoRoboYFinalIndex < 0 || posicaoRoboXFinalIndex < 0) {
						System.out.println("\nVocê perdeu!");
						System.exit(0);
					}
				}
			}
			
			System.out.println("\nVocê andou " + passos + " cm para " + direcao.toLowerCase() + " (" + passos/10 + " quadradinho(s)). \n");
			
			
			if (posicaoRoboXFinal == mapa.getWinPosX() && posicaoRoboYFinal == mapa.getWinPosY()) {
				System.out.println("\nVocê chegou ao objetivo!!!");
				System.out.println("Foi usado " + bob.getDistPercorrida() + "W de energia.");
				sc.close();
				System.exit(0);
			}
				
			}		
		
		
		}
	
	}


