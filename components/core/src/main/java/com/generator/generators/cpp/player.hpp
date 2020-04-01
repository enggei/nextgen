#ifndef __PLAYER_HPP__
#define __PLAYER_HPP__
#include <string>
namespace test {
class Player {
public:
const std::string& doSomething(int value, const long constValue, std::string& refValue, const int& constRefValue) const;

protected:
void whatever(void* functionRef);

private:
static void abc123();
static int staticVariable;
bool flag;
}; // class Player
} // namespace test
#endif // __PLAYER_HPP__