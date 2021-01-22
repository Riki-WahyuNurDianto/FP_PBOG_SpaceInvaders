package sprite;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Boss extends Sprite {
	private List<Bomb> bombs = new ArrayList<>();
	private int health = 20;
    private final int POINT = 5000;
    private int Width;
    private int Height;
    
    //Constructor
    public Boss(int x, int y) {
        initBoss(x, y);
    }

    private void initBoss(int x, int y) {
        this.x = x;
        this.y = y;

        bombs.add(new Bomb(x, y));
        bombs.add(new Bomb(x, y));
        bombs.add(new Bomb(x, y));
        
        var bossImg = "images/boss.png";
        var ii = new ImageIcon(bossImg);

        setWidth(ii.getIconWidth());
        setHeight(ii.getIconHeight());
        
        setImage(ii.getImage());
    }
    
    //Method
    public void act(int direction) {
        this.x += direction;
    }
    
    public void bombReposition() {
    	int num = 1;
    	for(Bomb bomb : bombs) {
    		if(num == 1) {
        		bomb.setX(this.x);
        		bomb.setY(this.y);
    		} else if(num == 2) {
    			bomb.setX(this.x + getWidth()/2);
        		bomb.setY(this.y + 10);
    		} else if(num == 3) {
        		bomb.setX(this.x + getWidth());
        		bomb.setY(this.y);
    		}
    		num++;
    	}
    }
    
    //Getter Setter
    public List<Bomb> getBomb() {
        return bombs;
    }
    
    public int getPoint() {
    	return POINT;
    }
    
    public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getWidth() {
		return Width;
	}

	public void setWidth(int width) {
		Width = width;
	}

	public int getHeight() {
		return Height;
	}

	public void setHeight(int height) {
		Height = height;
	}

	//Inner Class
    public class Bomb extends Sprite {
        private boolean destroyed;
        public Bomb(int x, int y) {
            initBomb(x, y);
        }

        private void initBomb(int x, int y) {
            setDestroyed(true);
            
            this.x = x;
            this.y = y;
            
            var bombImg = "images/bomb.png";
            var ii = new ImageIcon(bombImg);
            setImage(ii.getImage());
        }

        public void setDestroyed(boolean destroyed) {
            this.destroyed = destroyed;
        }

        public boolean isDestroyed() {
            return destroyed;
        }
    }
}
