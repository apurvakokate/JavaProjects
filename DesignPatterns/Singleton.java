public class Singleton {
  //only 1 instance of a singleton should be present at a time
  private static Singleton instance;
  private Singleton() {}
  public Singleton getInstance() {
    if(instance == null) {
      instance = New Singleton();
    }
    return instance;
  }
  //other methods
}
