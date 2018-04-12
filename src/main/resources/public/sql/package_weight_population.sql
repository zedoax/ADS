-- This is a script to populate the package_weight database
-- package_weight entries are in the following format:
-- package_weight(weight_class, cost_modifier)
-- package_class(package_type, cost_modifier)

insert into package_weight VALUES
('0 - 5', 1.0),
('5 - 10', 2.0),
('10 - 20', 3.0),
('20 - 35',9.5);
('35+',10.0);