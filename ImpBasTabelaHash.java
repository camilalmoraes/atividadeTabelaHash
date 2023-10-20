package TabelaHash;

public class ImpBasTabelaHash {

    // Método para calcular o hash de uma string
    public static int hash(String entrada) {
        int codigoHash = 0;
        int primo = 31; // Um número primo usado na função hash

        for (int i = 0; i < entrada.length(); i++) {
            char character = entrada.charAt(i);
            codigoHash = codigoHash * primo + (int) character;
        }

        return codigoHash;
    }

    public static void main(String[] args) {
        ImpBasTabelaHash hashFunction = new ImpBasTabelaHash();

        String input = "Camila";
        int codigoHash = 0;
        codigoHash = ImpBasTabelaHash.hash(input);
        System.out.println("Hash para '" + input + "': " + codigoHash);
    }
}

