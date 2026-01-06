package zona_fit.datos;
import zona_fit.conection.Conect;
import zona_fit.domain.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO{

    @Override
    public List<Client> clientList() {
        List<Client> clients = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection conect = Conect.getConect();
        var query = "SELECT * FROM CLIENT";
        try {
            ps = conect.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                var client = new Client();
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setLastName(rs.getString("lastName"));
                client.setMembership(rs.getInt("membership"));
                clients.add(client);
            }
        }catch (Exception e){
            System.out.println("Unexpected error while listing clients" + e.getMessage());
        }
        finally{
            try {
                conect.close();
            }catch (Exception e){
                System.out.println("Unexpected error while closing connection" + e.getMessage());
            }
        }
        return clients;
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
