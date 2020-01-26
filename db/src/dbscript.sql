-- schema owner
CREATE USER practice WITH password 'practice';

-- schema user
CREATE USER practice_ms WITH password 'practice_ms';

-- create schema
CREATE SCHEMA practice AUTHORIZATION practice;

GRANT USAGE ON SCHEMA practice TO practice_ms;

ALTER DEFAULT PRIVILEGES FOR USER practice_ms IN SCHEMA practice GRANT SELECT,INSERT,UPDATE,DELETE,TRUNCATE  ON TABLES TO practice_ms;
ALTER DEFAULT PRIVILEGES FOR USER practice_ms IN SCHEMA practice GRANT USAGE ON SEQUENCES TO practice_ms;
ALTER DEFAULT PRIVILEGES FOR USER practice_ms IN SCHEMA practice GRANT EXECUTE ON FUNCTIONS  TO practice_ms;