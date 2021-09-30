package main.order;

import javafx.scene.Parent;
import manager.commonMA.ManagerDTO;

public class OrderDTO {
	Parent root;

	public int americano = 2000, latte = 3000, capuccino = 3000, vanilaLatte = 4000;
	public static int cntA = 0, cntL = 0, cntC = 0, cntV = 0;
	public static int bean = 20, water = 150, milk = 150, VanilaSyrup = 20, ice = 100;
	public static int iceI = 0, sizeI = 0;
	public static ManagerDTO dto;

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

}