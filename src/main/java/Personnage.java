import java.util.Random;

public abstract class Personnage {

  protected int pv;
  protected int force;
  protected int energie = 100;
  protected int defense = 0;
  protected int minDamage = 5;
  protected int maxDamage = 10;
  protected boolean mort;

  /**
   * Permet de récupérer le statut Mort du personnage
   * @return mort Booléen du statut
   */

  public boolean getMort() {
    return mort;
  }

  /**
   * Permet de setter le statut Mort du personnage
   */

  public void setMort() {
    this.mort = true;
  }

  /**
   * Methode d'attaque afin d'infliger des dégats à l'adversaire
   * dégats aleatoire en fonction de maxDamage et minDamage
   */

  public int attaquer() {
    this.energie -= 40;

    if (this.energie < 0) {
      System.out.println("Pas assez d'energie -> Attaque affaiblie");
      this.energie = 0;
      int degats = 5;
      return degats;
    }

    Random rand = new Random();
    int degats = 10;//(rand.nextInt(maxDamage - minDamage + 1) + minDamage); // * force/10;
    return degats;
  }

  /**
   * Méthode permettant de subir les dégats (Baisse les PV)
   * @param degats Nombre de dégats subis par le personnage
   */
  public void subir(int degats) {
    int newPV = (this.getPV() - (degats * (100 - defense) / 100));

    this.setPV(newPV);

    //
    if (newPV <= 0) {
      this.setPV(0);
      this.setMort();
    }
    resetDefense();
  }

  /**
   * Methode permettant de recuperer de l'energie
   */
  public void gainEnergy() {
    this.energie += 25;
  }

  /**
   * Méthode permettant de récupérer la valeur de l'energie du personnage
   * @return energie valeur d'energie du personnage
   */
  public int showEnergy() {
    return this.energie;
  }

  /**
   * Permet de récupérer les points de vie du personnage
   * @return pv int des points de vie
   */
  public int getPV() {
    return this.pv;
  }


  /**
   * Permet de setter les points de vie du personnage
   * @param pv Nouveau PV du personnage
   */
  public void setPV(int pv) {
    this.pv = pv;
  }

  /**
   * Permet de réduire les dégats subis
   */
  public void parer() {
    this.energie -= 15;

    if (this.energie < 0){
      System.out.println("Pas assez d'energie -> Parade affaiblie");
      this.energie = 0;
      this.defense = 30;
    }
    else{
      this.defense = 70;
    }
  }

  public void resetDefense() {
    this.defense = 0;
  };

  public abstract void draw();
}
