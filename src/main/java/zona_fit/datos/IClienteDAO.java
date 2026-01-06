package zona_fit.datos;

import zona_fit.domain.Client;

import java.util.List;

public interface IClienteDAO {
    List<Client> clientList();
    boolean searchClientId(Client client);
    boolean insertClient(Client client);
    boolean updateClient(Client client);
    boolean deleteClient(Client client);
}
