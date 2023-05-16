package entities;

public class Robo {	
	
public Robo(int posicaoX, int posicaoY) {
		super();
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
	}


int posicaoX, posicaoY; 
double distPercorrida;

public double getDistPercorrida() {
	return distPercorrida;
}

public int getPosicaoX() {
	return posicaoX;
}

public void setPosicaoX(int posicaoX) {
	this.posicaoX = posicaoX;
}

public int getPosicaoY() {
	return posicaoY;
}

public void setPosicaoY(int posicaoY) {
	this.posicaoY = posicaoY;
}

public void getPosicao() {
	System.out.println(this.posicaoX + ", " + this.posicaoY);;
}


public void moveUp(int passos) {
	setPosicaoY(posicaoY+passos);
	this.distPercorrida += passos/10;
}
	
public void moveDown(int passos) {
	setPosicaoY(posicaoY-passos);
	this.distPercorrida += passos/10;
}
	
	
public void moveLeft(int passos) {
	setPosicaoX(posicaoX-passos);
	this.distPercorrida += passos/10;
}
	
	
public void moveRight(int passos) {
	setPosicaoX(posicaoX+passos);
	this.distPercorrida += passos/10;
}
	
	
}
