create view person_table_view as
select *
from Person, PersonTeam
where Person.id = PersonTeam.personId; 

1. Views (Section 7.3, for Monday)
	a. Write a simple view specification. For details on Oracle views, see Managing Views.
	b. Define the following terms (in the comments of your SQL command file).
		i. Base Tables
			i. A table who's tuples are always stored physically in the database
		ii. Join Views
			i. A view that involves multiple tables joined together.
		iii. Updateable Join Views
			i. Join views that can be updated to reflect changes to the data in a table or the schema
		iv. Key-Preserved Tables
			i.  a table is key preserved if the table key participates in the view as a key.  In short, a key-preserved table has its key columns preservedthrough a SQL join
		v. Views that are implemented via query modification vs materialization. (For details on Oracle materialization, see Materialized View Concepts and Architecture, focusing on the “What is a Materialized View?” and “Why Use Materialized Views” sections.)
			i. Query Modification
				1) Modifying or transforming the view query into a query on the underlying base tables
			ii. Materialization
Physically creating a temporary or permanent view table when the view is first queried or created and keeping that table on the assumption that other queries on the view will follow.
