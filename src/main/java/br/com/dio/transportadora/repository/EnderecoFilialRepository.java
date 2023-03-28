package br.com.dio.transportadora.repository;

import br.com.dio.transportadora.entity.EnderecoFilial;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EnderecoFilialRepository {
    private final Map<String, String> filiais;

    public EnderecoFilialRepository() {
        this.filiais = new HashMap<String, String>();

        filiais.put(EnderecoFilial.AC.toString(), "69950000");
        filiais.put(EnderecoFilial.AM.toString(), "69050000");
        filiais.put(EnderecoFilial.AL.toString(), "57050000");
        filiais.put(EnderecoFilial.AP.toString(), "68915000");
        filiais.put(EnderecoFilial.BA.toString(), "41510000");
        filiais.put(EnderecoFilial.CE.toString(), "60510000");
        filiais.put(EnderecoFilial.DF.toString(), "71510000");
        filiais.put(EnderecoFilial.ES.toString(), "29150000");
        filiais.put(EnderecoFilial.GO.toString(), "74003010");
        filiais.put(EnderecoFilial.MA.toString(), "65050000");
        filiais.put(EnderecoFilial.MG.toString(), "31510000");
        filiais.put(EnderecoFilial.MS.toString(), "79100010");
        filiais.put(EnderecoFilial.MT.toString(), "78050010");
        filiais.put(EnderecoFilial.PA.toString(), "66010020");
        filiais.put(EnderecoFilial.PB.toString(), "58010010");
        filiais.put(EnderecoFilial.PE.toString(), "51010015");
        filiais.put(EnderecoFilial.PI.toString(), "64010010");
        filiais.put(EnderecoFilial.PR.toString(), "81050010");
        filiais.put(EnderecoFilial.RJ.toString(), "21550020");
        filiais.put(EnderecoFilial.RN.toString(), "59050010");
        filiais.put(EnderecoFilial.RO.toString(), "76806610");
        filiais.put(EnderecoFilial.RR.toString(), "69301020");
        filiais.put(EnderecoFilial.RS.toString(), "90050010");
        filiais.put(EnderecoFilial.SC.toString(), "88050010");
        filiais.put(EnderecoFilial.SE.toString(), "49050010");
        filiais.put(EnderecoFilial.SP.toString(), "05050010");
        filiais.put(EnderecoFilial.TO.toString(), "77001004");
    }

    public String obterCep(String uf) {
        return filiais.get(uf);
    }
}
