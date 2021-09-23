package test01;



import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class oder01Impl implements oder01 {

    Parent root;
    int americano=2000,latte=3000,capuccino=3000,vanilaLatte=4000;
    int cntA=0,cntL=0,cntC=0,cntV=0,sum=0;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
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

    @Override
    public void setRoot(Parent root) {
        this.root=root;
    }

    @Override
    public void clickAmericano() {
        TextArea taMenu = (TextArea)root.lookup("#taMenu");
        taMenu.appendText("아메리카노\n");
        cntA++;
        setCntA(cntA);
        System.out.println("A:"+getCntA());
//        TextField tfPrice = (TextField)root.lookup("#tfPrice");
//        tfPrice.setText("2000원");
        Label labelPrice = (Label)root.lookup("#labelPrice");
        sum+=getCntA()*americano;
        setCntA(0);
        labelPrice.setText(sum+"원");
    }
@Override
    public void clickLatte() {
        TextArea taMenu = (TextArea)root.lookup("#taMenu");
        taMenu.appendText("카페라떼\n");
        cntL++;
        setCntL(cntL);
        System.out.println("L:"+getCntL());
        Label labelPrice = (Label)root.lookup("#labelPrice");
        sum+=getCntL()latte;
        setCntL(0);
        labelPrice.setText(sum+"원");

    }

    @Override
    public void clickCapuccino() {
        TextArea taMenu = (TextArea)root.lookup("#taMenu");
        taMenu.appendText("카푸치노\n");
        cntC++;
        setCntC(cntC);
        Label labelPrice = (Label)root.lookup("#labelPrice");
        sum+=getCntC()capuccino;
        setCntC(0);
        labelPrice.setText(sum+"원");

    }

    @Override
    public void clickVanilaLatte() {
        TextArea taMenu = (TextArea)root.lookup("#taMenu");
        taMenu.appendText("바닐라라떼\n");
        cntV++;
        setCntV(cntV);
        Label labelPrice = (Label)root.lookup("#labelPrice");
        sum+=getCntV()*vanilaLatte;
        setCntV(0);
        labelPrice.setText(sum+"원");
    }




}