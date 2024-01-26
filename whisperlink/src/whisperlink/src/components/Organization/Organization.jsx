import React, { useEffect, useState } from "react";
import { dataService } from "../../modules/DataService.js";

const OrganizationComponent = () => {
    const [organizations, setOrganizations] = useState([]);
    const [id, setId] = useState(0);
    const [name, setName] = useState("");
    const [description, setDescription] = useState("");

    useEffect(() => {
        dataService.getOrganizations()
            .then((response) => setOrganizations(response.data))
            .catch((error) => console.error("Error fetching data:", error));
    }, []);

    const createOrganization = (event) => {
        event.preventDefault();

        const newOrganization = {
            name: name,
            description: description,
        };

        dataService.createOrganization(newOrganization);
        document.location.reload();
    };

    const updateOrganization = (event) => {
        event.preventDefault();

        const updatedOrganization = {
            id: id,
            name: name,
            description: description,
        };

        dataService.updateOrganization(id, updatedOrganization);
        document.location.reload();
    };

    const deleteOrganization = (id) => {
        dataService.deleteOrganization(id)
            .then(() => {
                // Reload the data after successful deletion
                document.location.reload();
            })
            .catch((error) => {
                console.error("Error deleting organization:", error);
            });
    };


    return (
        <div>
            <h1>Organizations</h1>
            <form>
                Name: <input type="text" name="name" value={name} onChange={(e) => setName(e.target.value)} />
                Description: <input type="text" name="description" value={description} onChange={(e) => setDescription(e.target.value)} />
                <input type="submit" value="Create" onClick={createOrganization} />

                Id: <input type="number" name="id" value={id} onChange={(e) => setId(e.target.value)} />
                <input type="submit" value="Update" onClick={updateOrganization} />
            </form>

            <hr />

            <table>
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Operation</th>
                </tr>
                </thead>
                <tbody>
                {organizations.map((organization) => (
                    <tr key={organization.id}>
                        <td>{organization.id}</td>
                        <td>{organization.name}</td>
                        <td>{organization.description}</td>
                        <td><button onClick={() => deleteOrganization(organization.id)}>Delete</button></td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default OrganizationComponent;

