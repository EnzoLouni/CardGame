#!/bin/bash

set -e

psql -U ${POSTGRES_USER:-card} ${POSTGRES_DB:-postgres} <<-EOSQL
	SELECT 'CREATE DATABASE ${CARD_GAME:-cardgame_db}' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = '${CARD_GAME:-cardgame}')\gexec ;
    \c ${CARD_GAME:-cardgame_db};
    CREATE SCHEMA IF NOT EXISTS card AUTHORIZATION ${CARD_GAME_USER:-card};
    CREATE SCHEMA IF NOT EXISTS player AUTHORIZATION ${CARD_GAME_USER:-card};
    GRANT ALL PRIVILEGES ON DATABASE ${CARD_GAME:-cardgame_db} TO ${CARD_GAME_USER:-card};
EOSQL