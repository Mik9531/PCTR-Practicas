// Miguel Afán Espinosa
// Practica 6
// suavImagen.java




import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.*;
import java.util.concurrent.*;

public class suavImagen{ 
	public static int[][]matriz;
	public static Scanner x=new Scanner(System.in);
	public static Random r=new Random();
	
	public static void main(String[] args) throws IOException { 
		int n;
		long comienzo,fin;
		System.out.println("Numero de filas y columnas"); 
		n=x.nextInt();
		matriz=new int[n][n];
		for (int i = 0; i<n; i++){
			for (int j = 0; j<n; j++){
			matriz[i][j] = r.nextInt(21);}
		}
		comienzo=System.currentTimeMillis();
		for (int h = 0; h<n; h++){
			for (int k = 0; k<n; k++){ 
				if(h==0 || k==0 || h==n-1 || k==n-1){
					if(h==0 && k==n-1) matriz[h][k] = (4*(matriz[h][k])-(matriz[h+1][k])-(matriz[h][k-1]))/8;
					if(h==0 && k==0) matriz[h][k] = (4*(matriz[h][k])-(matriz[h+1][k])-(matriz[h][k+1]))/8;
					if(h==0 && k!=0 && k!=n-1) matriz[h][k] = (4*(matriz[h][k])-(matriz[h+1][k])-(matriz[h][k+1])-(matriz[h][k-1]))/8;
					if(k==0 && h==n-1) matriz[h][k] = (4*(matriz[h][k])-(matriz[h][k+1])-(matriz[h-1][k]))/8;
					if(k==0 && h!=0 && h!=n-1) matriz[h][k] = (4*(matriz[h][k])-(matriz[h+1][k])-(matriz[h][k+1])-(matriz[h-1][k]))/8;
					if(k==0 && h==n-1) matriz[h][k] = (4*(matriz[h][k])-(matriz[h][k+1])-(matriz[h-1][k]))/8;
					if(k!=0 && h==n-1 && k!=n-1) matriz[h][k] = (4*(matriz[h][k])-(matriz[h][k+1])-(matriz[h-1][k])-(matriz[h][k-1]))/8;
					if(h!=0 && k==n-1 && h!=n-1) matriz[h][k] = (4*(matriz[h][k])-(matriz[h+1][k])-(matriz[h-1][k])-(matriz[h][k-1]))/8;
				}
				else matriz[h][k]=(4*(matriz[h][k])-(matriz[h+1][k])-(matriz[h][k+1])-(matriz[h-1][k])-(matriz[h][k-1]))/8;
				if(matriz[h][k]<0) matriz[h][k]=matriz[h][k]*(-1);
			}
		}
		fin=System.currentTimeMillis();
		System.out.println("El tiempo de ejecucion es "+(fin - comienzo)+" milisegundos");
	
		
		}
	public static void Mostrar(int[][] matriz){
		for (int i=0; i < matriz.length; i++){
			System.out.print("|");
			for (int j=0; j < matriz[i].length; j++) {
				System.out.print(" "+matriz[i][j]+" ");
			}
			System.out.println("|");
		}
	}

	public static void guardar(int[][] matriz, String fichero) throws IOException{
        
		BufferedImage imagen = new BufferedImage(matriz[0].length, matriz.length, BufferedImage.TYPE_4BYTE_ABGR);
        
		int i = 0;
		for(int inti = 0 ; i<matriz.length; ++i)
		{
			for(int j = 0 ; j < matriz[0].length ; ++j)
			{
				Color c=new Color(matriz[j][i], matriz[j][i], matriz[j][i]);
				imagen.setRGB(i, j, c.getRGB());
			}
		}
		ImageIO.write(imagen, "png", new File(fichero));
        }
    
        public static void ConvertirAGris(String ficheroOriginal, String ficheroResultado) throws IOException {
        
        BufferedImage imagen=ImageIO.read(new File(ficheroOriginal));
        
        	for(int i = 0 ; i < imagen.getHeight() ; ++i)
        	{
        		for(int j = 0 ; j < imagen.getWidth() ; ++j)
        		{
        			Color c = new Color(imagen.getRGB(i, j));
        			int gris = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
        			imagen.setRGB(i, j, (new Color(gris, gris, gris)).getRGB());
        		}
        	}
        	ImageIO.write(imagen, "png", new File(ficheroResultado));
        }
    	public static int[][] cargar(String fichero) throws IOException{
        
    		BufferedImage imagen = ImageIO.read(new File(fichero));
        
    		int[][] matriz = new int[imagen.getHeight()][imagen.getWidth()];
        
    		for(int i = 0 ; i < imagen.getHeight() ; ++i)
    		{
    			for(int j = 0 ; j < imagen.getWidth() ; ++j)
    			{
    				Color c = new Color(imagen.getRGB(j, i));
    				matriz[i][j] = (int) ((c.getRed() + c.getGreen() + c.getBlue()) / 3);
    			}
    		}
    		return matriz;
    	}
}
