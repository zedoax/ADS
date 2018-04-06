create view u_package_v as
select package_id, weight_class, package_type, hazardous
from package_db;