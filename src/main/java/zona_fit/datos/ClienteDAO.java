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
                client.setLastName(rs.getString("last_name"));
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
        PreparedStatement ps;
        ResultSet rs;
        var conect = Conect.getConect();
        var query = "SELECT * FROM CLIENT WHERE id = ?";
        try{
            ps = conect.prepareStatement(query);
            ps.setInt(1, client.getId());
            rs = ps.executeQuery();
            if(rs.next()){
                client.setName(rs.getString("name"));
                client.setLastName(rs.getString("last_name"));
                client.setMembership(rs.getInt("membership"));
                return true;
            }
        }catch (Exception e){
            System.out.println("Unexpected error while searching client by id" + e.getMessage());
        }
        finally {
            try {
                conect.close();
            } catch (Exception e) {
                System.out.println("Unexpected error while closing connection" + e.getMessage());
            }
        }
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

    public static void main(String[] args) {

        IClienteDAO clienteDAO = new ClienteDAO();

//      //Listar clientes
//        System.out.println("*** LISTAR CLIENTES ***");
//        var clients = clienteDAO.clientList();
//        clients.forEach(System.out::println);
        //Buscar por ID
        var client1 = new Client(1);
        System.out.println("Client before search: \n" + client1);
        var founded = clienteDAO.searchClientId(client1);
        if (founded) {
            System.out.println("Client found: \n" + client1);
        }else {
            System.out.println("Client not found: \n" + client1.getId());
        }
        }

    }
