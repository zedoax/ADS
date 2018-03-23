-- This is a script to populate the package_class database
-- package_class entries are in the following format:
-- package_class(package_type, cost_modifier)
-- package_class(varchar(20), float)

insert into package_class VALUES
('envelope', 2.3),
('small box', 5.1),
('large box', 9.4),
('flat', 1.0),
