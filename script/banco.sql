
create database ams2024;

use ams2024;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


CREATE TABLE `grupos` (
  `id` bigint(20) NOT NULL,
  `nomeGrupo` varchar(255) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO `grupos` (`id`, `nomeGrupo`, `descricao`) VALUES
(1, 'AMS2024', 'Grupo dos alunos do curso AMS DS 2024');


CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO `usuarios` (`id`, `login`, `senha`, `tipo`) VALUES
(1, 'Daniel', '123456', 'adm'),
(2, 'Matheus', '282828', 'comum');


CREATE TABLE `usuarios_grupos` (
  `id` bigint(20) NOT NULL,
  `idU` bigint(20) NOT NULL,
  `idG` bigint(20) NOT NULL,
  `relacao` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO `usuarios_grupos` (`id`, `idU`, `idG`) VALUES
(1, 1, 1);

ALTER TABLE `grupos`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `usuarios_grupos`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `grupo`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;


ALTER TABLE `usuarios`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;


ALTER TABLE `usuarios_grupos`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;


