package memory;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JToggleButton;

public class EtatMemoire {

    private List<JToggleButton> listeBoutonsSelectionnes = new ArrayList<>();

    private void verifierNombreCartesRetournees() {
        if (listeBoutonsSelectionnes.size() >= 2) {
            for (JToggleButton jToggleButton : listeBoutonsSelectionnes) {
                jToggleButton.setSelected(false);
            }
            //vide la liste
            listeBoutonsSelectionnes.clear();
        }
    }
    private void verifierCartesIdentiques() {
        if (listeBoutonsSelectionnes.size() == 2) {
            if(listeBoutonsSelectionnes.get(0).getClientProperty("carte")
                    .equals(listeBoutonsSelectionnes.get(1).getClientProperty("carte"))) {
                //Les deux cartes sont identiques:
                //on les désactive:
                for (JToggleButton jToggleButton : listeBoutonsSelectionnes) {
                    jToggleButton.setEnabled(false);
                }
                //Et on vide la liste (pour éviter qu'elles ne soient
                //à nouveau retournées:
                listeBoutonsSelectionnes.clear();
            }
        }
    }

    public void nouveauBoutonSelectionne(JToggleButton button) {
        //On vérifie si le bouton est déjà dans la liste
        if(!listeBoutonsSelectionnes.contains(button)) {
            //Si deux boutons sont déjà sélectionnés:
            verifierNombreCartesRetournees();
    
            //Maintenant que les autres boutons sont cachés, 
            //stocke le nouveau dans la liste
            listeBoutonsSelectionnes.add(button);
    
            //Si deux boutons sont désormais présents dans la liste, 
            //comparons-les
            verifierCartesIdentiques();
        }
    }
}