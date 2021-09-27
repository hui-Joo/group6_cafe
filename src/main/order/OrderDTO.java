package main.order;

import javafx.scene.Parent;
import manager.commonMA.ManagerDTO;

public class OrderDTO {
	Parent root;
	public int americano = 2000, latte = 3000, capuccino = 3000, vanilaLatte = 4000;
	public static int cntA = 0, cntL = 0, cntC = 0, cntV = 0;
	public static int bean = 50, water = 150, milk = 100, VanilaSyrup = 5;
	public static int sum = 0;
	public static ManagerDTO dto;

	public Parent getRoot() {
		return root;
	}

	public void setRoot(Parent root) {
		this.root = root;
	}

	public int getAmericano() {
		return americano;
	}

	public void setAmericano(int americano) {
		this.americano = americano;
	}

	public int getLatte() {
		return latte;
	}

	public void setLatte(int latte) {
		this.latte = latte;
	}

	public int getCapuccino() {
		return capuccino;
	}

	public void setCapuccino(int capuccino) {
		this.capuccino = capuccino;
	}

	public int getVanilaLatte() {
		return vanilaLatte;
	}

	public void setVanilaLatte(int vanilaLatte) {
		this.vanilaLatte = vanilaLatte;
	}

	public int getCntA() {
		return cntA;
	}

	public void setCntA(int cntA) {
		this.cntA = cntA;
	}

	public int getCntL() {
		return cntL;
	}

	public void setCntL(int cntL) {
		this.cntL = cntL;
	}

	public int getCntC() {
		return cntC;
	}

	public void setCntC(int cntC) {
		this.cntC = cntC;
	}

	public int getCntV() {
		return cntV;
	}

	public void setCntV(int cntV) {
		this.cntV = cntV;
	}

	public static int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

}