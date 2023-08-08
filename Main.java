class Cliente {
    String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }
}

class ContaCorrente {
    String numero;
    String tipo;
    Cliente primeiroTitular;
    Cliente segundoTitular;
    double saldo;
    double limiteTotal;

    public ContaCorrente(String numero, String tipo, Cliente primeiroTitular, double limiteTotal) {
        this.numero = numero;
        this.tipo = tipo;
        this.primeiroTitular = primeiroTitular;
        this.limiteTotal = limiteTotal;
    }

    public void credito(double valor) {
        saldo += valor;
    }

    public void debito(double valor) {
        saldo -= valor;
    }

    public void imprimirResumo() {
        System.out.println("Número da Conta Corrente: " + numero);
        System.out.println("Nome do Primeiro Titular: " + primeiroTitular.nome);

        if (segundoTitular != null) {
            System.out.println("Nome do Segundo Titular: " + segundoTitular.nome);
        }

        System.out.println("Saldo Atual: " + saldo);
        System.out.println("Limite Atual: " + (limiteTotal + saldo));
        System.out.println("Limite Total: " + limiteTotal);

        if (saldo < 0) {
            System.out.println("Procurando o seu gerente");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Cliente primeiroTitular = new Cliente("Primeiro Titular");
        Cliente segundoTitular = new Cliente("Segundo Titular");

        ContaCorrente conta = new ContaCorrente("123456", "Corrente", primeiroTitular, 1000.0);
        conta.segundoTitular = segundoTitular;

        conta.credito(500.0);
        conta.debito(200.0);

        conta.imprimirResumo();
    }
}
