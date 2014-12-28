package parking.business;

import parking.exception.NombrePlacesMaxException;
import parking.exception.PlaceLibreException;
import parking.exception.PlaceOccupeeException;

public class Particulier implements Place{

	private int numeroPlace;
	private Vehicule vehicule;
	private String type;

	public Particulier() {
		try{
			if(Parking.getNbPlacesMax() == Parking.getNumeroPlace())
				throw new NombrePlacesMaxException();
			this.numeroPlace = Parking.getNumeroPlace();
			Parking.setNumeroPlace(Parking.getNumeroPlace()+1);
			this.type = "Particulier";
		}
		catch(NombrePlacesMaxException e){
			System.out.println("Le parking a atteint le nombre maximal de places");
		}
	}// Constructeur()

	@Override
	public String toString() {
		return "Particulier [numeroPlace=" + numeroPlace + ", vehicule="
				+ vehicule + "]";
	}// toString()

	public Vehicule getVehicule() {
		return vehicule;
	}//getVehicule()

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}// setVehicule()

	public int getNumero() { return numeroPlace; }//getNumero()

	public String getType() { return type; }//getType()

	public void park(Vehicule v) {
		try{
			if(this.vehicule != null | v instanceof Camion) // NE PAS UTILISER instanceof
				throw new PlaceOccupeeException();
			setVehicule(v);
		}
		catch(PlaceOccupeeException e){
			System.out.println("La place " + numeroPlace + " est d�j� occup�e et/ou n'est pas adapt�e � ce v�hicule");
		}
	}// park()

	public Vehicule unpark() {
		try {
			if(this.vehicule == null)
				throw new PlaceLibreException();
			Vehicule vehicule_renvoyé = this.vehicule;
			setVehicule(null);
			return vehicule_renvoyé;
		}
		catch (PlaceLibreException e) {
			System.out.println("La place " + numeroPlace + "est dèja vide.");
			return null;
		}
	}// unpark()

}
