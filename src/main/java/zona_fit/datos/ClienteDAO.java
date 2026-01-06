package zona_fit.datos;
import zona_fit.domain.Client;
import java.util.List;

public class ClienteDAO implements IClienteDAO{

    @Override
    public List<Client> clientList() {
        return List.of();
    }

    @Override
    public boolean searchClientId(Client client) {
        return false;
    }

    @Override
    public boolean insertClient(Client client) {
        return false;
    }

    @Override
    public boolean updateClient(Client client) {
        return false;
    }

    @Override
    public boolean deleteClient(Client client) {
        return false;
    }
}
