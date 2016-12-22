package tp3.model.reservation.repository;

import java.util.ArrayList;

import tp3.model.reservation.receipt.ReceiptBuilder;

public interface ReceiptRepository { // @SM: ??  Quelle horreur? Un repository de builder?? C'est un raccourci épouvantable
	//@SM: donc, ce que vous allez stocker dans votre repository c'est une collection de builder (!) avec des DTO!!
	
	public void add(ReceiptBuilder receipt);
	public ArrayList<ReceiptBuilder> listAll();
	int count();
	
}
