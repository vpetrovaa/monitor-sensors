# Configuration

This project uses several environment variables for configuring the application. Please make sure you have them set correctly in your `.env` file or directly in your environment.

## Required Environment Variables

Below are the required environment variables for this project:

| Variable            | Description                           | Default Value |
|---------------------|---------------------------------------|---------------|
| `POSTGRES_USERNAME`  | The username for PostgreSQL database. | `postgres`    |
| `POSTGRES_PASSWORD`  | The password for PostgreSQL database. | `postgres`    |
| `POSTGRES_HOST`      | The host where PostgreSQL is running. | `localhost`   |

## Example `.env` File

Create a `.env` file in the root of your project and add the following variables:

```env
POSTGRES_USERNAME=postgres
POSTGRES_PASSWORD=postgres
POSTGRES_HOST=localhost
