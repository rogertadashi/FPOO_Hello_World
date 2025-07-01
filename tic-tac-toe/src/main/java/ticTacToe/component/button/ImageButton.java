package ticTacToe.component.button;

public class ImageButton extends Button {
    private String imagePath;

    public ImageButton(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public void paint() {
        System.out.println("Desenhando ImageButton com imagem: " + imagePath);
    }
   
}