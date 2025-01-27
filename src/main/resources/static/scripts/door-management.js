/**
 * Fetches all countries from the backend.
 * @returns {Promise<Array>} List of countries
 */
async function fetchDoors() {
    const response = await fetch(`${apiBase}/door`);
    if (!response.ok) throw new Error("Failed to fetch doors");
    return response.json();
}

/**
 * Submits consulate data to the backend.
 * @param {Object} payload
 * @returns {Promise<void>}
 */
async function createDoor(payload) {
    const response = await fetch(`${apiBase}/door`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(payload),
    });
    if (!response.ok) throw new Error("Failed to create door");
}

/**
 * Deletes a consulate by ID.
 * @param {string} doorNumber - The ID of the consulate to delete.
 * @returns {Promise<void>}
 */
async function deleteDoorByDoorNumber(doorNumber) {
    const response = await fetch(`${apiBase}/door/${doorNumber}`, {
        method: "DELETE"
    });
    if (!response.ok) throw new Error("Failed to delete door");
}