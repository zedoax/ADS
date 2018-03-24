-- This is a script to populate the package_weight database
-- package_weight entries are in the following format:
-- package_weight(weight_class, cost_modifier)
-- package_class(package_type, cost_modifier)

insert into package_weight VALUES
('light', 1.0),
('heavy', 2.0),
('very heavy', 3.0),
('unliftable',9.5);