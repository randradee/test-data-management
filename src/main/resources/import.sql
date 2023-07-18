INSERT INTO tb_test_suite (id, name) VALUES (1, 'test1');
INSERT INTO tb_test_case(id, name, test_suite_id) VALUES (1, 'case1', 1);
INSERT INTO tb_test_case(id, name, test_suite_id) VALUES (2, 'case2', 1);

INSERT INTO tb_test_suite (id, name) VALUES (2, 'test2');
INSERT INTO tb_test_case(id, name, test_suite_id) VALUES (3, 'case3', 2);
INSERT INTO tb_test_case(id, name, test_suite_id) VALUES (4, 'case4', 2);