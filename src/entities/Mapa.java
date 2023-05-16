package entities;

public class Mapa {
	
	
	public Mapa(int linhas,int colunas, int startPosX, int startPosY, int winPosX, int winPosY) {
		super();
		this.startPosX = startPosX;
		this.startPosY = startPosY;
		this.winPosX = winPosX;
		this.winPosY = winPosY;
		this.paredes = new Parede[linhas][colunas];
		
		for(int i=0; i<linhas; i++) {
			for(int j=0; j<colunas; j++) {
				paredes[i][j] = new Parede(true);
			}
		}
	}
	
	public void removerParede(int i, int j) {
		paredes[i][j].existe = false;
	}
	
	
	int startPosX, startPosY, winPosX, winPosY;
	
	public int getStartPosX() {
		return startPosX;
	}
	public void setStartPosX(int startPosX) {
		this.startPosX = startPosX;
	}
	public int getStartPosY() {
		return startPosY;
	}
	public void setStartPosY(int startPosY) {
		this.startPosY = startPosY;
	}
	public int getWinPosX() {
		return winPosX;
	}
	public void setWinPosX(int winPosX) {
		this.winPosX = winPosX;
	}
	public int getWinPosY() {
		return winPosY;
	}
	public void setWinPosY(int winPosY) {
		this.winPosY = winPosY;
	}	
	
	public Parede[][] paredes;
	
	
}
