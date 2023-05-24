package entities;

public class Robo {	
	
public Robo(int posicaoX, int posicaoY, double energia) {
		super();
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		this.energia = energia;
	}


int posicaoX, posicaoY; 
double distPercorrida, energia;

public double getDistPercorrida() {
	return distPercorrida;
}

public double getEnergia() {
	return energia;
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
	if (distPercorrida + passos/10 < energia) {
		setPosicaoY(posicaoY+passos);
		this.distPercorrida += (double)passos/10;
	} else {
		setPosicaoY(posicaoY + (int)((energia - distPercorrida)*10));
		this.distPercorrida = energia;
	}
}
	
public void moveDown(int passos) {
	if (distPercorrida + passos/10 < energia) {
		setPosicaoY(posicaoY-passos);
		this.distPercorrida += (double)passos/10;
	} else {
		setPosicaoY(posicaoY - (int)((energia - distPercorrida)*10));
		this.distPercorrida = energia;
	}
}
	
	
public void moveLeft(int passos) {
	if (distPercorrida + passos/10 < energia) {
		setPosicaoX(posicaoX-passos);
		this.distPercorrida += (double)passos/10;
	} else {
		setPosicaoX(posicaoX - (int)((energia - distPercorrida)*10));
		this.distPercorrida = energia;
	}
}
	
	
public void moveRight(int passos) {
	if (distPercorrida + passos/10 < energia) {
		setPosicaoX(posicaoX+passos);
		this.distPercorrida += (double)passos/10;
	} else {
		setPosicaoX(posicaoX + (int)((energia - distPercorrida)*10));
		this.distPercorrida = energia;
	}
}
	
	
}
