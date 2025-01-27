const apiBase = "http://localhost:8080/api"

/**
 * Fetches all countries from the backend.
 * @param {string} doorNumber
 * @returns {Promise<Array>} List of countries
 */
async function fetchAccessesForDoor(doorNumber) {
    const response = await fetch(`${apiBase}/access/${doorNumber}`);
    if (!response.ok) throw new Error("Failed to fetch accesses for door with number " + doorNumber);
    return response.json();
}

/**
 * Fetches consulate details by ID.
 * @param {string} doorNumber
 * @param {string} rfid
 * @returns {Promise<Object>} Consulate details
 */
async function giveAccess(doorNumber, rfid) {
    const response = await fetch(`${apiBase}/access/give/${doorNumber}/${rfid}`, {
        method: "POST"
    });
    if (!response.ok) throw new Error("Failed to give access");
}

/**
 * Fetches consulate details by ID.
 * @param {string} doorNumber
 * @param {string} rfid
 * @returns {Promise<Object>} Consulate details
 */
async function removeAccess(doorNumber, rfid) {
    const response = await fetch(`${apiBase}/access/remove/${doorNumber}/${rfid}`, {
        method: "POST"
    });
    if (!response.ok) throw new Error("Failed to remove access");
}