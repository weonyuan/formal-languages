import java.awt.Color;

public class EspabloBuffer {
  private Color color;
  private int location;
  private String value;

  public EspabloBuffer() {}
  
  public EspabloBuffer(Color color, int location, String value) {
    this.color = color;
    this.location = location;
    this.value = value;
  }
  
  // Getters
  public Color getColor() {
    return this.color;
  }
  
  public int getLocation() {
    return this.location;
  }
  
  public String getValue() {
    return this.value;
  }
  
  // Setters
  public void setColor(Color color) {
    this.color = color;
  }
  
  public void setLocation(int location) {
    this.location = location;
  }
  
  public void setValue(String value) {
    this.value = value;
  }
}
