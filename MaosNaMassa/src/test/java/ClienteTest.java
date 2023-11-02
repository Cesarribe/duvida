import br.com.cesar.generic.JDBC.dao.ClienteDAO;
import br.com.cesar.generic.JDBC.dao.IClienteDAO;
import domain.Cliente;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteTest {

    @Test
    public void cadastrarTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCodigo("1");
        cliente.setNome("cesar");
        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());
    }
}
