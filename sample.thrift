
namespace java com.factual.samples.thrift
namespace rb Factual.Thrift


enum Gender{
	FEMALE = 1
	MALE = 2
}

struct Person
{
	1: optional string uuid
	2: required string first_name
	3: required string last_name
	4: optional string middle_name
	5: optional Gender gender
}