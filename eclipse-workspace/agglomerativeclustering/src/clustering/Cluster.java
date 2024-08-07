package clustering;
import data.*;
public class Cluster {

    private Integer[] clusteredData =new Integer[0];

    //add the index of a sample to the cluster
    void addData(int id){
        // controllo duplicati
        for(int i=0; i<clusteredData.length;i++)
            if(id==clusteredData[i])
                return;
        Integer clusteredDataTemp[]=new Integer[clusteredData.length+1];
        System.arraycopy(clusteredData, 0, clusteredDataTemp, 0, clusteredData.length);
        clusteredData=clusteredDataTemp;
        clusteredData[clusteredData.length-1]=id;
    }


    public int getSize() {
        return clusteredData.length;
    }

    public int getElement(int i) throws ArrayIndexOutOfBoundsException{
        if(i<0 ||i>clusteredData.length-1){
            throw new ArrayIndexOutOfBoundsException("indice deve essere compreso tra 0 e"+ (clusteredData.length-1));
        }else{
            return clusteredData[i];
        }
    }

    // crea una copia del cluster corrente
    Cluster createACopy() {
        Cluster copyC=new Cluster();
        for (int i=0;i<getSize();i++)
            copyC.addData(clusteredData[i]);
        return copyC;
    }

    // crea un nuovo cluster che è la fusione dei due cluster pre-esistenti
    Cluster mergeCluster (Cluster c)
    {
        Cluster newC=new Cluster();
        for (int i=0;i<getSize();i++)
            newC.addData(clusteredData[i]);
        for (int i=0;i<c.getSize();i++)
            newC.addData(c.clusteredData[i]);
        return newC;

    }


    public String toString() {
        StringBuilder str= new StringBuilder();
        for (int i=0;i<clusteredData.length-1;i++)
            str.append(clusteredData[i]).append(",");
        str.append(clusteredData[clusteredData.length - 1]);
        return str.toString();
    }

    String toString(Data data){
        StringBuilder str= new StringBuilder();

        for(int i=0;i<clusteredData.length;i++)
            str.append("<").append(data.getExample(clusteredData[i])).append(">");

        return str.toString();

    }



}
