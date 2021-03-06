package Classes;

import java.util.ArrayList;

public class GamSys {
    private Loja loja;
    private Usuario usuarioLogado;
    private ArrayList<Comunidade> comunidades;
    
    public GamSys() {
        this.loja = new Loja();
        comunidades = new ArrayList<Comunidade>();
    }
    public void adicionarAComunidade(int idComunidade, int idSolicitado){
        usuarioLogado.atualizarListaDeComunidades(idComunidade);
        for(Comunidade a : comunidades){
            if(a.getIdComunidade() == idComunidade)a.atualizaListaDeMembros(idSolicitado);
        }
    }
    public void adicionarUsuario(int idSolicitado, int idSolicitante){
        Usuario novoUsuario = Usuario.buscarUsuario(idSolicitado);
        
        usuarioLogado.atualizarListaAmigos(idSolicitado);
        novoUsuario.atualizarListaAmigos(idSolicitante);
    }
    
    
    public void atualizarListaAmigo(int idNovoAmigo){
        //
    }
    public void alterarDadosComunidade(String nome, boolean tipo, String descricao, int idComunidade){
        for(Comunidade a : comunidades){
            if(a.getIdComunidade() == idComunidade)a.atualizarDados(nome, tipo, descricao);
        }
    }
    public void atualizarDadosUsuario(String nome, String email, String senha, String cpf){
        usuarioLogado.atualizarDados(nome, email, senha, cpf);
    }
    public void alteraProdutoLoja(String nome, String descricao, int idSoftware, float valor){
        loja.alterarInformacoesProduto(nome, descricao, idSoftware, valor);
    }
    public void atualizarSoftware(int idSoftware){
        usuarioLogado.atualizarSoftware(idSoftware);
    }
    public void downloadSoftware(int idSoftware){
        usuarioLogado.fazerDownloadSoftware(idSoftware);
    }
    public void introduzirProdutoCarrinho(Software produto){
        usuarioLogado.solicitarIntroducaoProdutoCarrinho(produto);
    }
    
    public void criarComunidade(String nome, boolean tipo, String descricao, int idCriador){
        Comunidade novaComunidade = new Comunidade(nome, tipo, descricao, idCriador);
        comunidades.add(novaComunidade);
    }
    public void criarConta(String nome, String email, String senha, String cpf){
        Usuario novoUsuario = new Usuario(nome, senha, email, cpf, false);
        //Armazenar usuario em meio persistente
        //-------------------------------------Prototipo
    }
    public void enviarMensagem(int idDestinatario, int idRemetente, String mensagem){
        Usuario destino;
        
        destino = Usuario.buscarUsuario(idDestinatario);
        
        usuarioLogado.adicionarMensagemConversa(mensagem, idDestinatario, idRemetente);
        destino.adicionarMensagemConversa(mensagem, idDestinatario, idRemetente);
    }
    public ArrayList<Software> procurarProduto(String nome){
        return loja.localizarProdutos(nome);
    }
    public void enviarMensagemComunidade(int idComunidade, int idRemetente, String texto){
        //
    }
    public void buscarUsuario(String email, String senha){
        //
    }
    public void removerUsuarioComunidade(int idMembro, int idComunidade){
        for(Comunidade a : comunidades){
            if(a.getIdComunidade() == idComunidade){
                a.removerMembro(idMembro);
            }
        }
    }
    
    public Usuario getUsuarioLogado(){
        return usuarioLogado;
    }
    
    public boolean fazerLogin(String email, String senha){
        usuarioLogado = Usuario.buscarUsuario(email, senha);
        return usuarioLogado != null;
    }

    public boolean fazerPagamento(String numero, int codigoSeg, String nome) {
        usuarioLogado.atualizarBiblioteca();
        return true;//---------------------Prototipo
    }

    public void criarNovoPost(int idComunidade, String texto, int remetente) {
        if(idComunidade < comunidades.size()){
            comunidades.get(idComunidade).criarNovoPost(remetente, texto);
        }
    }
    
    public int buscaUsuarioNome(String nome){
        int id=0;
        //
        return id;
    }
    
}
