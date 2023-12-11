package entities;

import java.util.ArrayList;
import java.util.List;

public class Loja {

    protected List<Cds> lista_cds = new ArrayList<>();

    public void adicionar_cd (Cds cd){
        lista_cds.add(cd);
    }
}
